HBaseConfiguration conf =  HBaseConfiguration.create();
Job job = new Job(conf,"JOB_NAME");
    job.setJarByClass(yourclass.class);
    job.setMapperClass(yourMapper.class);
    job.setMapOutputKeyClass(Text.class);
    job.setMapOutputValueClass(Intwritable.class);
    FileInputFormat.setInputPaths(job, new Path(inputPath));
    TableMapReduceUtil.initTableReducerJob(TABLE,
            yourReducer.class, job);
    job.setReducerClass(yourReducer.class);
            job.waitForCompletion(true);