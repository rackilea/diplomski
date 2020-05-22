package patentcitation;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.KeyValueTextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class MyJob
{
    public static class Mymapper extends Mapper <Text, Text, Text, Text>
    {
        public void map(Text key, Text value, Context context) throws IOException, InterruptedException
        {
                context.write(key, value);
        }

    }
    public static class Myreducer extends Reducer<Text,Text,Text,Text>
    {

        public void reduce(Text key, Iterable<Text> value, Context context) throws IOException, InterruptedException
        {
            StringBuilder str = new StringBuilder();

            for(Text x : value)
            {
                if(str.length() > 0)
                {
                    str.append(",");
                }
                str.append(x.toString());
            }
            context.write(key, new Text(str.toString()));
        }

    }
    public static void main(String args[]) throws IOException, ClassNotFoundException, InterruptedException
    {
        Configuration conf = new Configuration();
        conf.set("mapreduce.input.keyvaluelinerecordreader.key.value.separator",",");
        Job job = Job.getInstance(conf, "PatentCitation");
        FileSystem fs = FileSystem.get(conf);
        job.setJarByClass(MyJob.class);
        FileInputFormat.addInputPath(job,new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        job.setMapperClass(Mymapper.class);
        job.setReducerClass(Myreducer.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);
        job.setInputFormatClass(KeyValueTextInputFormat.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        /*if(fs.exists(new Path(args[1]))){
            //If exist delete the output path
            fs.delete(new Path(args[1]),true);
        }*/
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}