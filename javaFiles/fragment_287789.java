package trail;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class ParseWeblogs extends Configured implements Tool {

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Configuration conf = new Configuration();
        try {
            int res = ToolRunner.run(conf, new ParseWeblogs(), args);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public int run(String[] args) {
        // TODO Auto-generated method stub
        Configuration conf = new Configuration();
        /*
         * Arguments
         */
        String source = args[0];
        String dest = args[1];
        FileSystem fs = null;
        try {
            fs = FileSystem.get(conf);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Path in = new Path(source);
        Path out = new Path(dest);

        Job weblogJob = null;
        try {
            weblogJob = new Job(conf, "ParseWeblogs");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        weblogJob.setJarByClass(ParseWeblogs.class);
        weblogJob.setMapperClass(CLFMapper.class);
        weblogJob.setMapOutputKeyClass(Text.class);
        weblogJob.setMapOutputValueClass(Text.class);
        weblogJob.setOutputKeyClass(Text.class);
        weblogJob.setOutputValueClass(Text.class);
        try {
            TextInputFormat.addInputPath(weblogJob, in);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        /*
         * Delete output dir if exist
         */
        try {
            if (fs.exists(out)) {
                fs.delete(out, true);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        TextOutputFormat.setOutputPath(weblogJob, out);
        boolean success = false ;
        try {
            success = weblogJob.waitForCompletion(true);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return success ?0:1;
    }
}