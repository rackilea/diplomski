...
Job job = new Job(conf, "MyJob");

Configuration map1Conf = new Configuration(false); 
... ChainMapper.addMapper(job, AMap.class, LongWritable.class, Text.class, Text.class, Text.class, true, map1Conf);

Configuration map2Conf = new Configuration(false); 
... ChainMapper.addMapper(job, BMap.class, Text.class, Text.class, LongWritable.class, Text.class, false, map2Conf);

Configuration map3Conf = new Configuration(false); 
... ChainReducer.setReducer(job, CReducer.class, Text.class, Text.class, LongWritable.class, Text.class, false, map3Conf);
...

job.waitForComplettion(true);
...