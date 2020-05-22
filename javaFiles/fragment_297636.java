public static class Reduce extends Reducer<Text, Text, NullWritable, Text>{
    private final Integer MAXIMUM_VALUE = Integer.MIN_VALUE;
    public void reduce(Text commonKey, Iterable<Text> values, Context context){
        Integer finalMax = MAXIMUM_VALUE;
        String finalKey;
        for (Text value: values){
            String[] kvpair = value.toString().trim().split(",")
            if(Integer.parseInt(kvpair[1]) > finalMax){
                finalKey = kvpair[0];
                finalMax = Integer.parseInt(kvpair[1]);
            }
        }
        context.write(new Text(finalKey), new IntWritable(finalMax) );
    }
}