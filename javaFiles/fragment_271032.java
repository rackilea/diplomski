...
String tableName = "mytable";
Configuration conf = HBaseConfiguration.create();
conf.addResource(new Path("/home/user/hbase/conf/hbase-site.xml"));

HBaseAdmin admin = new HBaseAdmin(conf);
admin.majorCompact(tableName);
...