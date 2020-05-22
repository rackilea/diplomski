import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hdfs.DistributedFileSystem;

DistributedFileSystem fileSystem = new DistributedFileSystem();
Configuration conf = new Configuration();
fileSystem.initialize(new URI("hdfs://namenode-host:54310"), conf);
FSDataInputStream input = fileSystem.open(new Path("/path/to/file.csv"));
System.out.println((new BufferedReader(new InputStreamReader(input))).readLine());