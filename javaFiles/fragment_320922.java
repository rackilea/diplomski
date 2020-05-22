public class YourReducer extends MapReduceBase implements Reducer<Text, Text, Text, Text> {

    public void reduce(Text key, Iterator<Text> values, OutputCollector<Text, Text> output, Reporter reporter) throws IOException {

         int count_outs = 0;
         int count_ins  = 0;

            while (values.hasNext()) {

              Text value = (Text) values.next();

              String value_str = value.toString();

              if(value_str.equals("out"))
                 count_outs++;
              else
              if(value_str.equals("in"))
                 count_ins++;  

            }

            Text out = new Text(count_ins + " " + count_outs);              
            output.collect(key, out);

    }//end reduce function

}//end reducer class