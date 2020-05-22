public static class TempMapper extends Mapper<LongWritable, Text, IntWritable, FloatWritable>{

  @Override
  protected void map(LongWritable key, Text value, Context context)
                throws IOException, InterruptedException {
       //code for getting date and temperature
       String temp = columns.get(3);
       context.write(new IntWritable(year), new FloatWritable(Float.valueOf(temp)));
  }
}