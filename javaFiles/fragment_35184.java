CompositeWritable out; // null here
  Text textYearlyValue = new Text();

  public void reduce(Text key, Iterable<IntWritable> values,
      Context context)
      throws IOException, InterruptedException {
         out.merge(values); // still null, should throw an exception