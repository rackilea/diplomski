import java.io.*;
  import java.sql.*;
  public class DirectoryList
  {
     public static void getList(File directory) throws SQLException {
        File path = new File(directory);
        File[] listOfFiles = path.listFiles();
        for (File file : listOfFiles)
        {
          if (file.isFile())
          {   
             #sql {
                      call Load_File_List_p(:file, :directory)
                  };
          }
        }
     }
  }