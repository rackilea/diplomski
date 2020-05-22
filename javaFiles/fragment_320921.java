public class YourMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, Text> {

      public void map(LongWritable key, Text value, OutputCollector<Text, Text> output, Reporter reporter) throws IOException {

        String line = value.toString();     
        String[] line_spl = line.split(" ");

        String node1 = line_spl[0];
        String node2 = line_spl[1];

        Text node1_txt = new Text(node1);
        Text node2_txt = new Text(node2);
        Text emit_out = new Text("out");
        Text emit_in  = new Text("in");

        output.collect(node1_txt, emit_out);
        output.collect(node2_txt, emit_in );

      }//end map function


}//end mapper class