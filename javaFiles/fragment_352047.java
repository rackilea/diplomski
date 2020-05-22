import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;


    public class IndexCount {

       public static class Map extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {
         public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {

           String str=value.toString();
           String[] tokens = str.split(" "); //split into words
           //create hashmap for unique word
           HashMap<String,Integer> uniqueString = new HashMap<String,Integer>();
           for(int i=0;i<tokens.length;i++){
               uniqueString.put(tokens[i],1);
           }       
           //for sorting create TreeMap from above hash map
           TreeMap<String, Integer> map = new TreeMap<String,Integer>(uniqueString); 
            for (Entry<String, Integer> entry : map.entrySet()) {
               int index=0;
           //find the index of the word
               index = str.indexOf((String)entry.getKey());
               while (index >= 0) {
                       output.collect(new Text((String)entry.getKey()),new IntWritable(index));
                       index = str.indexOf((String)entry.getKey(), index + 1);
               }
           }
       }
    }
       public static class Reduce extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable> {
         public void reduce(Text key, Iterator<IntWritable> values, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {

           while (values.hasNext()) {
               output.collect(key, new IntWritable(values.next().get()));
           }

         } 
    }
       public static void main(String[] args) throws Exception {
         JobConf conf = new JobConf(WordCount.class);
         conf.setJobName("indexfinder");

         conf.setOutputKeyClass(Text.class);
         conf.setOutputValueClass(IntWritable.class);
         conf.setMapperClass(Map.class);
         conf.setCombinerClass(Reduce.class);
         conf.setReducerClass(Reduce.class);    
         conf.setInputFormat(TextInputFormat.class);
         conf.setOutputFormat(TextOutputFormat.class);

         FileInputFormat.setInputPaths(conf, new Path(args[0]));
         FileOutputFormat.setOutputPath(conf, new Path(args[1]));

         JobClient.runJob(conf);
       }
    }