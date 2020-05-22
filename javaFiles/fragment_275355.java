package test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class FtpTransfer {
 public static final void main(String[] args) throws SocketException, IOException {
  FTPClient ftp = new FTPClient();
  ftp.connect("ftp.somedomain.com"); // or "localhost" in your case
  System.out.println("login: "+ftp.login("username", "pass"));

  ftp.changeWorkingDirectory("folder/subfolder/");
  // list the files of the current directory
  FTPFile[] files = ftp.listFiles();  
  System.out.println("Listed "+files.length+" files.");
  for(FTPFile file : files) {
   System.out.println(file.getName());
  }
   // lets pretend there is a JPEG image in the present folder that we want to copy to the desktop (on a windows machine)
  ftp.setFileType(FTPClient.BINARY_FILE_TYPE); // don't forget to change to binary mode! or you will have a scrambled image!
        FileOutputStream br = new FileOutputStream("C:\\Documents and Settings\\casonkl\\Desktop\\my_downloaded_image_new_name.jpg");

  ftp.retrieveFile("name_of_image_on_server.jpg", br);
  ftp.disconnect();

 }
}