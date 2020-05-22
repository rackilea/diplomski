public static class MultiMapper 
        extends Mapper<LongWritable, Text, Text, IntWritable> {

    @Override
    public void map(LongWritable key, Text value, Context context) 
            throws IOException, InterruptedException {

        for (int i = 1; i <= n; i++) {
            context.write(value, new IntWritable(i));
        }
    }
}