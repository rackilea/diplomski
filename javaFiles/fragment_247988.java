public class HmkdirsFromEclipse {

public static void main(String[] args) 

        throws IOException 
        { 
Configuration conf = new Configuration();  
conf.addResource("/etc/hadoop/conf/core-site.xml");
conf.addResource("/etc/hadoop/conf/hdfs-site.xml");
conf.set("fs.defaultFS", "hdfs://quickstart.cloudera:8020/");
conf.set("hadoop.job.ugi", "cloudera");
conf.set("fs.hdfs.impl", org.apache.hadoop.hdfs.DistributedFileSystem.class.getName());
FileSystem fs = FileSystem.get(conf); 
boolean success = fs.mkdirs(new Path("/user/cloudera/testdirectory9"));
System.out.println(success);
        }