package com.myorg.hadooptests;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class MultiLineDemo {

       public static class MultiLineMapper
                extends Mapper<LongWritable, Text , Text, NullWritable> {

            public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
                context.write(value, NullWritable.get());
            }
        }

        public static void main(String[] args) throws Exception {

            Configuration conf = new Configuration();

            Job job = Job.getInstance(conf, "MultiLineMapper");
            job.setInputFormatClass(MultiLineInputFormat.class);

            job.setJarByClass(MultiLineDemo.class);
            job.setMapperClass(MultiLineMapper.class);

            job.setOutputKeyClass(Text.class);
            job.setOutputValueClass(NullWritable.class);

            FileInputFormat.addInputPath(job, new Path("/in/in8.txt"));
            FileOutputFormat.setOutputPath(job, new Path("/out/"));

            job.waitForCompletion(true);

    }
}