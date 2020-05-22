Configuration conf = new Configuration();
Job job = new Job(conf);
job.setMapperClass(MultithreadedMapper.class);
conf.set("mapred.map.multithreadedrunner.class", WebGraphMapper.class.getCanonicalName());
conf.set("mapred.map.multithreadedrunner.threads", "8");
job.setJarByClass(WebGraphMapper.class);
// rest ommitted
job.waitForCompletion(true);