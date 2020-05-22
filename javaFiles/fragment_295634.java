private final static IntWritable one = new IntWritable(1);
private Text word = new Text();
private String fileText = null;

public void map(Object key, Text value, Context context)
        throws IOException, InterruptedException {
    ...
}