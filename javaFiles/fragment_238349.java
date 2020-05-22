import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;
import java.util.StringTokenizer;


public class Q1 {

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "Q1");

        job.setJarByClass(Q1.class);
        job.setMapperClass(TargetMapper.class);
        job.setCombinerClass(EmailsReducer.class);
        job.setReducerClass(EmailsReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(MyWritable.class);
        job.setMapOutputValueClass(MyWritable.class);

        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }

    public static class TargetMapper extends Mapper<Object, Text, Text, MyWritable> {
        public void map(Object key, Text value, Context context
        ) throws IOException, InterruptedException {
            StringTokenizer st = new StringTokenizer(value.toString(), "\r");
            while (st.hasMoreTokens()) {
                String[] edge = st.nextToken().split("\t");
                Text target = new Text();
                target.set(edge[0]);
                int tgt = Integer.parseInt(edge[1]);
                int weight = Integer.parseInt(edge[2]);
                context.write(target, new MyWritable(tgt, weight));
            }
        }

    }

    public static class EmailsReducer extends Reducer<Text, MyWritable, Text, MyWritable> {
        private MyWritable res = new MyWritable();

        public void reduce(Text key, Iterable<MyWritable> targets, Context context) throws IOException, InterruptedException {
            int maxWeight = Integer.MIN_VALUE;
            int maxTgt = Integer.MIN_VALUE;

            for (MyWritable target : targets) {
                if (target.getWeight().get() > maxWeight) {
                    maxWeight = target.getWeight().get();
                    maxTgt = target.getTgt().get();
                }
            }

            res.set(new IntWritable(maxTgt), new IntWritable(maxWeight));

            context.write(key, res);
        }
    }
}