static class MySingleThreadMapper extends Mapper<LongWritable, Text, Text, Text> {

    static MyResource sharedResource;

    @Override
    protected void setup(Context context) throws IOException, InterruptedException {
        super.setup(context);
        synchronized (MySingleThreadMapper.class) {
             if (sharedResource == null) {
                 sharedResource = createResource();
             }
        }
    }

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
       // mapper code
       // sharedResource will be initialized here
    }
}