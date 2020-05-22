public class CompositeReducer extends Reducer<Text, IntWritable, Text, MinMaxAvgWritable> {

    private final MinMaxAvgWritable output = new MinMaxAvgWritable();

    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        // This 'set/merge' method could just as easily be defined here, and return a String to be set on a Text object
        output.set(values);  
        context.write(key, output);
    }
}