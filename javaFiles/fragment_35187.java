// outputs for mapper and reducer
    job.setOutputKeyClass(Text.class);

    // setup mapper
    job.setMapperClass(TokenizerMapper.class);  // Replace with your mapper
    job.setMapOutputValueClass(IntWritable.class);

    // setup reducer
    job.setReducerClass(CompositeReducer.class);
    job.setOutputValueClass(MinMaxAvgWritable.class); // notice custom writable

    FileInputFormat.addInputPath(job, new Path(args[0]));
    FileOutputFormat.setOutputPath(job, new Path(args[1]));

    return job.waitForCompletion(true) ? 0 : 1;