private Job createCubeJob(...) {
    //Build and Configure Job
    Job job = new Job(conf);
    job.setJobName(jobName);
    job.setMapOutputKeyClass(ImmutableBytesWritable.class);
    job.setMapOutputValueClass(Put.class);
    job.setMapperClass(HiveToHBaseMapper.class);//Custom Mapper
    job.setJarByClass(CubeBuilderDriver.class);
    job.setInputFormatClass(TextInputFormat.class);
    job.setOutputFormatClass(HFileOutputFormat.class);

    TextInputFormat.setInputPaths(job, hiveOutputDir);
    HFileOutputFormat.setOutputPath(job, cubeOutputPath);

    Configuration hConf = HBaseConfiguration.create(conf);
    hConf.set("hbase.zookeeper.quorum", hbaseZookeeperQuorum);
    hConf.set("hbase.zookeeper.property.clientPort", hbaseZookeeperClientPort);

    HTable hTable = new HTable(hConf, tableName);

    HFileOutputFormat.configureIncrementalLoad(job, hTable);
    return job;
}