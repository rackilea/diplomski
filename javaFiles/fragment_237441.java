...
Configuration conf = new Configuration();
conf.addResource(new Path("/home/user/hadoop/conf/core-site.xml"));
conf.addResource(new Path("/home/user/hadoop/conf/hdfs-site.xml"));

FileSystem fs = FileSystem.get(conf);
fs.copyFromLocalFile(new Path("/home/user/directory/"), 
  new Path("/user/hadoop/dir"));
...