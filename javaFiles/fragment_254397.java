// this should be like defined in your yarn-site.xml
conf.set("yarn.resourcemanager.address", "yarn-manager.com:50001"); 

// framework is now "yarn", should be defined like this in mapred-site.xm
conf.set("mapreduce.framework.name", "yarn");

// like defined in hdfs-site.xml
conf.set("fs.default.name", "hdfs://namenode.com:9000");