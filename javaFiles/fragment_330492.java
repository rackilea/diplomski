Configuration conf = new Configuration();
conf.set("fs.defaultFS", "hdfs://0.0.0.0:8020");
FileSystem fs = FileSystem.get(conf);

Configuration cconf = fs.getConf();
String block = cconf.get("dfs.blocksize");
long dsize = Long.parseLong(block);