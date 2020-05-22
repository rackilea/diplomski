public static enum UpdateCounter {
  UPDATED
}

 @Override
 public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

    if(value < 1) {
      context.getCounter(UpdateCounter.UPDATED).increment(1);
    }

    context.write(newKey, newValue);
}