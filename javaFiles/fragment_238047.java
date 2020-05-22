public static class Map extends Mapper<LongWritable, Text, Text, IntWritable> {

    private final String csvFile = "/workspace/project/src/subject.csv";
    private List<String> csvData = new ArrayList<>();

    protected void setup(Context context) throws IOException, InterruptedException {
         Configuration conf = context.getConfiguration();
          FileSystem fs = FileSystem.get(conf);
          Path p = new Path(csvFile); // this file must be on HDFS 
          // read csvFile from fs
          // store CSV records in some field 
    }