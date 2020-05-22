package com.myorg.hadooptests;

import com.google.common.io.Closeables;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DataOutputBuffer;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Reads records that are delimited by a specific begin/end tag.
 */
public class MultiLineInputFormat extends TextInputFormat {

    private static final Logger log = LoggerFactory.getLogger(MultiLineInputFormat.class);

    @Override
    public RecordReader<LongWritable, Text> createRecordReader(InputSplit split, TaskAttemptContext context) {
        try {
            return new MultiLineRecordReader((FileSplit) split, context.getConfiguration());
        } catch (IOException ioe) {
            log.warn("Error while creating MultiLineRecordReader", ioe);
            return null;
        }
    }

    /**
     * MultiLineRecordReader class to read through a given text document to output records containing multiple
     * lines as a single line
     *
     */
    public static class MultiLineRecordReader extends RecordReader<LongWritable, Text> {

        private final long start;
        private final long end;
        private final FSDataInputStream fsin;
        private final DataOutputBuffer buffer = new DataOutputBuffer();
        private LongWritable currentKey;
        private Text currentValue;

        private static final Logger log = LoggerFactory.getLogger(MultiLineRecordReader.class);

        public MultiLineRecordReader(FileSplit split, Configuration conf) throws IOException {

            // open the file and seek to the start of the split
            start = split.getStart();
            end = start + split.getLength();
            Path file = split.getPath();
            FileSystem fs = file.getFileSystem(conf);
            fsin = fs.open(split.getPath());
            fsin.seek(start);

            log.info("start: " + Long.toString(start) + " end: " + Long.toString(end));
        }

        private boolean next(LongWritable key, Text value) throws IOException {
            if (fsin.getPos() < end) {
                try {
                    log.info("Started reading");
                    if(readUntilEnd()) {
                        key.set(fsin.getPos());
                        value.set(buffer.getData(), 0, buffer.getLength());
                        return true;
                    }
                } finally {
                    buffer.reset();
                }
            }
            return false;
        }

        @Override
        public void close() throws IOException {
            Closeables.closeQuietly(fsin);
        }

        @Override
        public float getProgress() throws IOException {
            return (fsin.getPos() - start) / (float) (end - start);
        }

        private boolean readUntilEnd() throws IOException {
            boolean insideColumn = false;
            byte[] delimiterBytes = new String("\"").getBytes("utf-8");
            byte[] newLineBytes = new String("\n").getBytes("utf-8");

            while (true) {
                int b = fsin.read();

                // end of file:
                if (b == -1) return false;
                log.info("Read: " + b);

                // We encountered a Double Quote
                if(b == delimiterBytes[0]) {
                    if(!insideColumn)
                        insideColumn = true;
                    else
                        insideColumn = false;
                }

                // If we encounter a new line and we are not inside a columnt, it means end of record.
                if(b == newLineBytes[0] && !insideColumn) return true;

                // save to buffer:
                buffer.write(b);

                // see if we've passed the stop point:
                if (fsin.getPos() >= end) {
                    if(buffer.getLength() > 0) // If buffer has some data, then return true
                        return true;
                    else
                        return false;
                }
            }
        }

        @Override
        public LongWritable getCurrentKey() throws IOException, InterruptedException {
            return currentKey;
        }

        @Override
        public Text getCurrentValue() throws IOException, InterruptedException {
            return currentValue;
        }

        @Override
        public void initialize(InputSplit split, TaskAttemptContext context) throws IOException, InterruptedException {
        }

        @Override
        public boolean nextKeyValue() throws IOException, InterruptedException {
            currentKey = new LongWritable();
            currentValue = new Text();
            return next(currentKey, currentValue);
        }
    }
}