public int run(String[] arg) throws Exception {
    Configuration conf=getConf();
    FileSystem fs = FileSystem.get(conf);
    //estimate reducers
    Job job = new Job(conf);
    job.setJarByClass(WholeFileDriver.class);
    job.setJobName("WholeFile");
    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(Text.class);
    job.setInputFormatClass(WholeFileInputFormat.class);
    job.setMapperClass(WholeFileMapper.class);
    job.setNumReduceTasks(0);

    FileInputFormat.addInputPath(job, new Path(arg[0]));
    Path output=new Path(arg[1]);
    try {
        fs.delete(output, true);
    } catch (IOException e) {
        LOG.warn("Failed to delete temporary path", e);
    }
    FileOutputFormat.setOutputPath(job, output);

    boolean ret=job.waitForCompletion(true);
    if(!ret){
        throw new Exception("Job Failed");
    }