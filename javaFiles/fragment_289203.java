Your Class {
  private static final String OUTPUT_PATH;
}
main(){
 Configuration conf = new Configuration();
 FileSystem fs = FileSystem.get(conf);
 Job job = Job.getInstance(conf);
 job.setJarByClass(BookAnalyzer.class);
 job.setJobName("N-Gram Extraction");
 Path nGramOutput = new Path(OUTPUT_PATH);

 FileInputFormat.addInputPath(job,args[0]);
 FileOutputFormat.setOutputPath(job, nGramOutput);

 job.setMapperClass(BookNGramMapper.class);
 job.setReducerClass(BookNGramReducer.class);

 job.setOutputKeyClass(Text.class);
 job.setOutputValueClass(IntWritable.class);

 job.waitForCompletion(true);

 Configuration conf2 = getConf();
 Job job2 = Job.getInstance(conf2);
 job2.setJarByClass(BookAnalyzer.class);
 job2.setJobName("Term-frequency");

 FileInputFormat.addInputPath(job2, nGramOutput);
 FileOutputFormat.setOutputPath(job,new Path(args[1]));

 job2.setMapperClass(TermFreqMapper.class);
 job2.setReducerClass(TermFreqReducer.class);

 job2.setOutputKeyClass(Text.class);
 job2.setOutputValueClass(IntWritable.class);

 System.exit(job2.waitForCompletion(true) ? 0 : 1);
 }