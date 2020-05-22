package com.hadoop.crunch;

import java.io.*;
import java.util.Collection;
import java.util.Iterator;

import org.apache.crunch.*;
import org.apache.crunch.impl.mr.MRPipeline;
import org.apache.crunch.io.From;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.util.*;
import org.apache.log4j.Logger;

public class App extends Configured implements Tool, Serializable{
    private static final long serialVersionUID = 1L;
    private static Logger LOG = Logger.getLogger(App.class);

    @Override
    public int run(String[] args) throws Exception {
        final Path fileSource = new Path(args[0]);
        final Path outFileName = new Path(args[1], "event-" + System.currentTimeMillis() + ".txt");

        //MRPipeline translates the overall pipeline into one or more MapReduce jobs
        Pipeline pipeline = new MRPipeline(App.class, getConf());
        //Specify the input data to the pipeline. 
        //The input data is contained in PCollection
        PCollection<String> inDataPipe = pipeline.read(From.textFile(fileSource));

        //inject an operation into the crunch data pipeline
        PObject<Collection<String>> dataCollection = inDataPipe.asCollection();

        //iterate over the collection 
        Iterator<String> iterator = dataCollection.getValue().iterator();
        FileSystem fs = FileSystem.getLocal(getConf());
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fs.create(outFileName, true)));

        while(iterator.hasNext()){
            String data = iterator.next().toString();
            bufferedWriter.write(data);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        //Start the execution of the crunch pipeline, trigger the creation & execution of MR jobs
        PipelineResult result = pipeline.done();

        return result.succeeded() ? 0 : 1;
    }

    public static void main(String[] args) {
        if (args.length != 2)throw new RuntimeException("Usage: hadoop jar <inputPath> <outputPath>");
        try {
            ToolRunner.run(new Configuration(), new App(), args );
        } catch (Exception e) {
            LOG.error(e.getLocalizedMessage());
        }
    }

}