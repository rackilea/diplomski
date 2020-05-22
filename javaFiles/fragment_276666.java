Configuration conf = new Configuration();

    Job job = new Job(conf);
    job.setJobName("TEST JOB");

    List<String> other_args = parseArguments(args, job);

    DistributedCache.addFileToClassPath(new Path("/someHadoopFolder/JTS.jar"), conf);

    job.setMapOutputKeyClass(LongWritable.class);
    job.setMapOutputValueClass(Text.class);

    job.setOutputKeyClass(LongWritable.class);
    job.setOutputValueClass(Text.class);

    job.setMapperClass(myMapper.class);
    //job.setCombinerClass(myReducer.class);
    //job.setReducerClass(myReducer.class);

    job.setInputFormatClass(TextInputFormat.class);   
    job.setOutputFormatClass(TextOutputFormat.class);


    String inPath = other_args.get(0);
    String outPath = other_args.get(1);     
    TextInputFormat.setInputPaths(job, inPath);
    TextOutputFormat.setOutputPath(job, new Path(outPath));

    TextInputFormat.setMinInputSplitSize(job, 32 * MEGABYTES);
    TextInputFormat.setMaxInputSplitSize(job, 32 * MEGABYTES);

    job.setJarByClass(myFile.class);

    job.waitForCompletion(true);