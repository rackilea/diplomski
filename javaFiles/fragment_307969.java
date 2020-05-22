public static class KVReducer 
       extends Reducer<IntWritable,Text,IntWritable, Text> {

      KVReducer(){

          System.out.println("Inside reducer");
      }

      public void reduce(IntWritable key, Iterable<Text> values,Context context) throws IOException, InterruptedException {
        for(Text value: values){}
          System.out.println(value +" hello2 , world  " +key );
          context.write(key, value);
        }
      }
}