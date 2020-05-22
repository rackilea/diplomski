public class breducer extends Reducer<Text,NullWritable,Text,NullWritable>{
    @Overwrite
    public void reducer(Text key,Iterable<NullWritable> value,Context context) throws IOException,InterruptedException{
        // Your logic
    }
}