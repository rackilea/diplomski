package so3972768;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.net.ftp.FTPClient;

public class FtpUpload {

  private static void check(FTPClient ftp, String cmd, boolean succeeded) throws IOException {
    if (!succeeded) {
      throw new IOException("FTP error: " + ftp.getReplyString());
    }
  }

  private static String today() {
    return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
  }

  public void uploadfile(String server, String username, String Password, String sourcePath, String destDir) throws IOException {

    FTPClient ftp = new FTPClient();
    ftp.connect(server);
    try {
      check(ftp, "login", ftp.login(username, Password));

      System.out.println("Connected to " + server + ".");

      InputStream input = new FileInputStream(sourcePath);
      try {
        String destination = destDir;
        if (destination.endsWith("/")) {
          destination += today() + "-" + new File(sourcePath).getName();
        }
        check(ftp, "store", ftp.storeFile(destination, input));
        System.out.println("Stored " + sourcePath + " to " + destination + ".");
      } finally {
        input.close();
      }

      check(ftp, "logout", ftp.logout());

    } finally {
      ftp.disconnect();
    }
  }

  public static void main(String[] args) throws IOException {
    FtpUpload upload = new FtpUpload();
    upload.uploadfile("192.168.0.210", "muruganp", "vm4snk", "/home/media/Desktop/FTP Upload/data.doc", "/fileserver/filesbackup/Emac/");
  }

}