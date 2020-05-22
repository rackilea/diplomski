Job job = new Job();

 FileInputFormat.setInputPath(job, inDir);
 FileOutputFormat.setOutputPath(job, outDir);

 job.setMapperClass(MOMap.class);
 job.setReducerClass(MOReduce.class);
 ...

 // Defines additional single text based output 'text' for the job
 MultipleOutputs.addNamedOutput(job, "text", TextOutputFormat.class,
 LongWritable.class, Text.class);

 // Defines additional sequence-file based output 'sequence' for the job
 MultipleOutputs.addNamedOutput(job, "seq",
   SequenceFileOutputFormat.class,
   LongWritable.class, Text.class);
 ...

 job.waitForCompletion(true);
 ...