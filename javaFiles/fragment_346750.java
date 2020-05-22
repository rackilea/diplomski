import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hive.ql.exec.vector.VectorizedRowBatch;
import org.apache.hadoop.security.UserGroupInformation;
import org.apache.orc.OrcFile;
import org.apache.orc.Reader;
import org.apache.orc.RecordReader;
import org.apache.orc.TypeDescription;
import org.apache.orc.Writer;

import com.cloudera.org.joda.time.LocalDate;

public class OrcFileRollUp {

  private final static String SCHEMA = "journald.schema";
  private final static String UTF_8 = "UTF-8";
  private final static String HDFS_BASE_LOGS_DIR = "/<baseDir>/logs";
  private static final String keytabLocation = System.getProperty("keytab");
  private static final String kerberosUser = "<userName>";
  private static Writer writer;

  public static void main(String[] args) throws IOException {

    Configuration conf = new Configuration();
    conf.set("hadoop.security.authentication", "Kerberos");

    InetAddress myHost = InetAddress.getLocalHost();
    String kerberosPrincipal = String.format("%s/%s", kerberosUser, myHost.getHostName());
    UserGroupInformation.setConfiguration(conf);
    UserGroupInformation.loginUserFromKeytab(kerberosPrincipal, keytabLocation);

    int currentDay = LocalDate.now().getDayOfMonth();
    int currentMonth = LocalDate.now().getMonthOfYear();
    int currentYear = LocalDate.now().getYear();

    Path path = new Path(HDFS_BASE_LOGS_DIR);

    FileSystem fileSystem = path.getFileSystem(conf);
    System.out.println("The URI is: " + fileSystem.getUri());


    //Get Hosts:
    List<String> allHostsPath = getHosts(path, fileSystem);

    TypeDescription schema = TypeDescription.fromString(getSchema(SCHEMA)
        .replaceAll("\n", ""));

    //Open each file for reading and write contents
    for(int i = 0; i < allHostsPath.size(); i++) {

      String outFile = "." + currentYear + "_" + currentMonth + "_" + currentDay + ".orc.working";            //filename:  .2018_04_24.orc.working

      //Create list of files from directory and today's date OR pass a directory in via the command line in format 
      //hdfs://<namenode>:8020/HDFS_BASE_LOGS_DIR/<hostname>/2018/4/24/
      String directory = "";
      Path outFilePath;
      Path argsPath;
      List<String> orcFiles;

      if(args.length == 0) {
        directory = currentYear + "/" + currentMonth + "/" + currentDay;
        outFilePath = new Path(allHostsPath.get(i) + "/" + directory + "/" + outFile);
        try {
          orcFiles = getAllFilePath(new Path(allHostsPath.get(i) + "/" + directory), fileSystem);
        } catch (Exception e) {
          continue;
        }
      } else {
        outFilePath = new Path(args[0] + "/" + outFile);
        argsPath = new Path(args[0]);
        try {
          orcFiles = getAllFilePath(argsPath, fileSystem);
        } catch (Exception e) {
          continue;
        }
      }

      //Create List of files in the directory

      FileSystem fs = outFilePath.getFileSystem(conf);

      //Writer MUST be below ^^ or the combination file will be deleted as well.
      if(fs.exists(outFilePath)) {
        System.out.println(outFilePath + " exists, delete before continuing.");
      } else {
       writer = OrcFile.createWriter(outFilePath, OrcFile.writerOptions(conf)
            .setSchema(schema));
      }

      for(int j = 0; j < orcFiles.size(); j++ ) { 
        Reader reader = OrcFile.createReader(new Path(orcFiles.get(j)), OrcFile.readerOptions(conf));

        VectorizedRowBatch batch = reader.getSchema().createRowBatch();
        RecordReader rows = reader.rows();

        while (rows.nextBatch(batch)) {
          if (batch != null) {
             writer.addRowBatch(batch);
          }
        }
        rows.close();
        fs.delete(new Path(orcFiles.get(j)), false);
      }
      //Close File
      writer.close();

      //Remove leading "." from ORC file to make visible to Hive
      outFile = fileSystem.getFileStatus(outFilePath)
                                      .getPath()
                                      .getName();

      if (outFile.startsWith(".")) {
        outFile = outFile.substring(1);

        int lastIndexOf = outFile.lastIndexOf(".working");
        outFile = outFile.substring(0, lastIndexOf);
      }

      Path parent = outFilePath.getParent();

      fileSystem.rename(outFilePath, new Path(parent, outFile));

      if(args.length != 0)
        break;
    }
  }

  private static String getSchema(String resource) throws IOException {
    try (InputStream input = OrcFileRollUp.class.getResourceAsStream("/" + resource)) {
      return IOUtils.toString(input, UTF_8);
    }
  }

  public static List<String> getHosts(Path filePath, FileSystem fs) throws FileNotFoundException, IOException {
    List<String> hostsList = new ArrayList<String>();
    FileStatus[] fileStatus = fs.listStatus(filePath);
    for (FileStatus fileStat : fileStatus) {
      hostsList.add(fileStat.getPath().toString());
    }
    return hostsList;
  }

  private static List<String> getAllFilePath(Path filePath, FileSystem fs) throws FileNotFoundException, IOException {
    List<String> fileList = new ArrayList<String>();
    FileStatus[] fileStatus = fs.listStatus(filePath);
    for (FileStatus fileStat : fileStatus) {
      if (fileStat.isDirectory()) {
        fileList.addAll(getAllFilePath(fileStat.getPath(), fs));
      } else {
        fileList.add(fileStat.getPath()
                             .toString());
      }
    }
    for(int i = 0; i< fileList.size(); i++) {
      if(!fileList.get(i).endsWith(".orc"))
        fileList.remove(i);
    }

    return fileList;
  }

}