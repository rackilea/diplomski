class PosNegMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String s_arr[] = value.toString().split("\\s");
        int val = Integer.parseInt(s_arr[1]);
        context.write(new Text(s_arr[0]), new IntWritable(val));
    }

}

class PosNegReducer extends Reducer<Text, IntWritable, Text, Text> {

    @Override
    public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
      ArrayList<IntWritable> arls = new ArrayList<>();
      for( IntWritable val : values){
         arls.add(val);
      }
      if(arls.size()<2)
          arls.add(new IntWritable(0));
      String s = arls.get(0) + "p/" + arls.get(1) + "n" + System.getProperty("line.separator"); //Here, I took liberty that the word must be in both files.
      Text result=new Text(s);
      context.write(key, result);
    }

}