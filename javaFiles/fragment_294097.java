public static class SortLogsMapper extends Mapper<Object, Text, Text, NullWritable> {

public void map(Object, Text value, Context context) throws IOException, InterruptedException 
{       
    context.write(value, new NullWritable());
}