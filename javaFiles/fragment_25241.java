public static class TokenCounterReducer extends Reducer<Text, Text, Text, NullWritable> {
    public void reduce(Text key, Iterable<Text> values, Context context)
            throws IOException, InterruptedException {
        for (Text value : values) {
            JSONObject jsn = new JSONObject();
            ....
            context.write(new Text(jsn.toString()), null);
        }
    }
}