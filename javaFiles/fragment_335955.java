import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;

public class TopSites{

    public static class TagToSiteMapper extends Mapper<Object, Text, Text, Text> {

        public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
            String [] siteTag = value.toString().split("\t");
            context.write(new Text(siteTag[1]), new Text(siteTag[0]));
            System.out.println(siteTag[1] + " --> " + siteTag[0]);
        }
    }


    public static class TagToSiteReducer extends Reducer<Text, Text, Text, Text> {
        public void reduce(Text key, Iterable<Text> values, Context context)
                throws IOException, InterruptedException {
            String l =  "";
            System.out.print("Key: [" + key.toString() + "] Values: [");

            for (Text site : values)
                l += site + "\t";

            l=l.substring(0, l.length()-1);
            System.out.println(l + "]");
            context.write(new Text(key), new Text(l));
        }
    }
    public static class TopSiteMapper extends Mapper<Object, Text, Text, IntWritable> {
        private final static IntWritable one = new IntWritable(1);
        public void map(Object key, Text value, Context context) throws IOException, InterruptedException {

            String [] data = value.toString().split("\t");
            String sites ="";
            System.out.println("map received: "+ value.toString());

            for(int i=1;i<data.length;i++)
                sites += data[i] + "\t";    

            System.out.println(sites.substring(0,sites.length()-1));
            context.write(new Text(sites.substring(0,sites.length()-1)), one);
        }
    }

    public static class TopSiteReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
        public void reduce(Text key, Iterable<IntWritable> values, Context context)
                throws IOException, InterruptedException {
            int sum =  0;
            System.out.print("Key: [" + key.toString() + "] Values: [");

            for (IntWritable site : values){
                System.out.print(site.get());
                sum+=site.get();
            }
            System.out.println("]");
            context.write(new Text(key), new IntWritable(sum));
        }
    }

    public static void main(String[] args) throws Exception {

        Configuration conf = new Configuration();

        Job job  = Job.getInstance(conf, "site-to-tag");

        job.setJarByClass(TopSites.class);
        job.setMapperClass(TagToSiteMapper.class);
        job.setReducerClass(TagToSiteReducer.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        MultipleInputs.addInputPath(job,  new Path(args[0]),TextInputFormat.class, TagToSiteMapper.class);

        Path outputpath = new Path(args[1]+"_temp");
        FileOutputFormat.setOutputPath(job,outputpath);

        FileSystem fs = null;
        Path dstFilePath = new Path(args[1]);
        try {
            fs = dstFilePath.getFileSystem(conf);
            if (fs.exists(dstFilePath))
                fs.delete(dstFilePath, true);

            dstFilePath = new Path(args[1]+"_temp");
            fs = dstFilePath.getFileSystem(conf);
            if (fs.exists(dstFilePath))
                fs.delete(dstFilePath, true);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        int code = job.waitForCompletion(true)?0:1;
        if(code == 0)
        {
            Job SecondJob = Job.getInstance(conf, "Tag-to-Sites");
            SecondJob.setJarByClass(TopSites.class);

            SecondJob.setOutputKeyClass(Text.class);
            SecondJob.setOutputValueClass(IntWritable.class);

            SecondJob.setMapperClass(TopSiteMapper.class);
            SecondJob.setCombinerClass(TopSiteReducer.class);
            SecondJob.setReducerClass(TopSiteReducer.class);


            FileInputFormat.addInputPath(SecondJob,new Path(args[1]+ "_temp"));
            FileOutputFormat.setOutputPath(SecondJob,new Path(args[1]));
            int exitCode = SecondJob.waitForCompletion(true)?0:1;
            FileSystem.get(conf).delete(new Path(args[1]+"_temp"), true);
            System.exit(exitCode);
        }
    }
}