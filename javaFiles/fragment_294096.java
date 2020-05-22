public class AnalyzeLogs
{       
    public static class FindFriendMapper extends Mapper<Object, Text, Text, IntWritable> {

    public void map(Object, Text value, Context context) throws IOException, InterruptedException 
    {       
        String tempStrings[] = value.toString().split(","); 
        context.write(new Text(tempStrings[2]), new IntWritable(1));
    }
}