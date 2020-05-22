package hadoop.boyermoore;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class BoyerMooreImpl {


      public static class TokenizerMapper
           extends Mapper<Object, Text, Text, IntWritable>{
        private BoyerMoore boyerMoore;
        private static IntWritable offset;
        private Text offsetFound = new Text("offset");

        public void map(Object key, Text value, Context context
                        ) throws IOException, InterruptedException {
          StringTokenizer itr = new StringTokenizer(value.toString());
          while (itr.hasMoreTokens()) {
              String line = itr.nextToken();
              int offset1 = boyerMoore.search(line);
              if (line.length() != offset1) {
                  offset = new IntWritable(offset1);
                  context.write(offsetFound,offset);
              }
          }
        }
        @Override
        public final void setup(Context context) {
            if (boyerMoore == null)
                boyerMoore = new BoyerMoore(context.getConfiguration().get("pattern"));
        }
      }


      public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        conf.set("pattern","your_pattern_here");
        Job job = Job.getInstance(conf, "BoyerMoore");
        job.setJarByClass(BoyerMooreImpl.class);
        job.setMapperClass(TokenizerMapper.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
      }
}