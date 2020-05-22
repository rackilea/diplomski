public static class Map extends MapReduceBase implements Mapper<LongWritable, Text, Text, DoubleWritable> {
  //  private final static IntWritable one = new IntWritable(1);
    //private Text word = new Text();
      double temp;

    public void map(LongWritable key, Text value, OutputCollector<Text, DoubleWritable> output, Reporter reporter) throws IOException {
      String line = value.toString();
      line=line.replaceAll("U","");
      int a=line.length();
      if(a>2)
      {
          int spec=line.indexOf(' ');
          String s=line.substring(spec,spec+9);
          String b=line.substring(spec+10,a);

      StringTokenizer tokenizer = new StringTokenizer(b);
      while (tokenizer.hasMoreTokens()) {
        {
            temp=Double.valueOf(tokenizer.nextToken().toString());
        }
        output.collect(new Text(s), new DoubleWritable(temp));
      }
    }
    }
  }