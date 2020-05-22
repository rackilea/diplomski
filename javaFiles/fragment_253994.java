package server;  
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
  import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


public class SimpleFileServer {

  public final static int SOCKET_PORT = 1328;
  public final static String FILE_NAME = "from.txt";  
  public final static String FILE_TO_SEND = "c:/temp/from.txt";
  public final static String ZIP_FILE_TO_SEND = "c:/temp/myFile.zip";

  public static void main (String [] args ) throws IOException {
    FileInputStream fis = null;
    BufferedInputStream bis = null;
    OutputStream os = null;
    ServerSocket servsock = null;
    Socket sock = null;


    zipIt();

    try {
      servsock = new ServerSocket(SOCKET_PORT);
      while (true) {
        System.out.println("Waiting...");
        try {
          sock = servsock.accept();
          System.out.println("Accepted connection : " + sock);
          // send file
          File myFile = new File (ZIP_FILE_TO_SEND);
          byte [] mybytearray  = new byte [(int)myFile.length()];
          fis = new FileInputStream(myFile);
          bis = new BufferedInputStream(fis);
          bis.read(mybytearray,0,mybytearray.length);
          os = sock.getOutputStream();
          System.out.println("Sending " + ZIP_FILE_TO_SEND + "(" + mybytearray.length + " bytes)");
          os.write(mybytearray,0,mybytearray.length);
          os.flush();
          System.out.println("Done.");
        }
        finally {
          if (bis != null) bis.close();
          if (os != null) os.close();
          if (sock!=null) sock.close();          
        }
      }
    }
    finally {
      if (servsock != null) servsock.close();
    }
  }

  public static void zipIt()
    {
        byte[] buffer = new byte[1024];

        try{

            FileOutputStream fos = new FileOutputStream(ZIP_FILE_TO_SEND);
            ZipOutputStream zos = new ZipOutputStream(fos);
            ZipEntry ze= new ZipEntry(FILE_NAME);
            zos.putNextEntry(ze);
            FileInputStream in = new FileInputStream(FILE_TO_SEND);

            int len;
            while ((len = in.read(buffer)) > 0) {
                zos.write(buffer, 0, len);
            }

            in.close();
            zos.closeEntry(); 
            zos.close();

            System.out.println("Zip Done");

        }catch(IOException ex){
           ex.printStackTrace();
        }
    }
}