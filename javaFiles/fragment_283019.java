JavaSparkContext context = new JavaSparkContext();

Job job;

try {
  job = Job.getInstance();
  FileInputFormat.setInputPaths(job, new Path("/path/to/input/directory));
  FileInputFormat.setInputDirRecursive(job, true);
} catch (IOException e1) {
  e1.printStackTrace();
  System.exit(1);
}

JavaRDD<Text> sourceData = context.newAPIHadoopRDD(job.getConfiguration(), TextInputFormat.class, LongWritable.class, Text.class)
  .values();