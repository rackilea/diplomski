public class MyRecordReader extends RecordReader<LongWritable, Text> {
    private static final int BUFFER_SIZE = 5;
    private static final String DELIMITER = ":";

    private Queue<String> valueBuffer = new LinkedList<String>();
    private Queue<Long> keyBuffer = new LinkedList<Long>();
    private LongWritable key = new LongWritable();
    private Text value = new Text();

    private RecordReader<LongWritable, Text> rr;
    public MyRecordReader(RecordReader<LongWritable, Text> rr) {
        this.rr = rr;
    }

    @Override
    public void close() throws IOException {
        rr.close();
    }

    @Override
    public LongWritable getCurrentKey() throws IOException, InterruptedException {
        return key;
    }

    @Override
    public Text getCurrentValue() throws IOException, InterruptedException {
        return value;
    }

    @Override
    public float getProgress() throws IOException, InterruptedException {
        return rr.getProgress();
    }

    @Override
    public void initialize(InputSplit arg0, TaskAttemptContext arg1)
            throws IOException, InterruptedException {
        rr.initialize(arg0, arg1);
    }

    @Override
    public boolean nextKeyValue() throws IOException, InterruptedException {
        if (valueBuffer.isEmpty()) {
            while (valueBuffer.size() < BUFFER_SIZE) {
                if (rr.nextKeyValue()) {
                    keyBuffer.add(rr.getCurrentKey().get());
                    valueBuffer.add(rr.getCurrentValue().toString());
                } else {
                    return false;
                }
            }
        } else {
            if (rr.nextKeyValue()) {
                keyBuffer.add(rr.getCurrentKey().get());
                valueBuffer.add(rr.getCurrentValue().toString());
                keyBuffer.remove();
                valueBuffer.remove();
            } else {
                return false;
            }
        }
        key.set(keyBuffer.peek());
        value.set(getValue());
        return true;
    }

    private String getValue() {
        StringBuilder sb = new StringBuilder();
        Iterator<String> iter = valueBuffer.iterator();
        while (iter.hasNext()) {
            sb.append(iter.next());
            if (iter.hasNext()) sb.append(DELIMITER);
        }
        return sb.toString();
    }

}