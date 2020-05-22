public class Hmkdirs {
public static void main(String[] args) 
        throws IOException 
        { 
Configuration conf = new Configuration();  
FileSystem fs = FileSystem.get(conf); 
boolean success = fs.mkdirs(new Path("/user/cloudera/testdirectory1"));
System.out.println(success);
        }