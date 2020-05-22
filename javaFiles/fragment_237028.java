import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.FSDataOutputStream;
import java.io.IOException;

public static void touch(String filePath) throws IOException {

  FileSystem hdfs = FileSystem.get(new Configuration());

  Path fileToTouch = new Path(filePath);

  FSDataOutputStream fos = null;

  // If the file already exists, we append an empty String just to modify
  // the timestamp:
  if (hdfs.exists(fileToTouch)) {
    fos = hdfs.append(new Path(filePath));
    fos.writeBytes("");
  }
  // Otherwise, we create an empty file:
  else {
    fos = hdfs.create(new Path(filePath));
  }

  fos.close();
}