import org.apache.hadoop.conf.Configuration
 import org.apache.hadoop.fs.FileSystem
 import org.apache.hadoop.fs.Path

 FileSystem file = FileSystem.get(new Configuration())

File[] sourceFiles = new File("/home/src").listFiles();
            if(sourceFiles != null) {
                for(File f: sourceFiles) {
                    //we can filter files if needed here
                    file.copyFromLocalFile(true, true, new Path(f.getPath()), new Path("/user/dest"));
                }
            }