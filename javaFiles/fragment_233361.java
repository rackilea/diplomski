public class MyTextInputFormat extends TextInputFormat {
    @Override
    public RecordReader<LongWritable, Text> createRecordReader(
                InputSplit arg0, TaskAttemptContext arg1) {
        return new MyRecordReader(super.createRecordReader(arg0, arg1));
    }
}