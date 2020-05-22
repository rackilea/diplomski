package server;  
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class SimpleFileClient {

  public final static int SOCKET_PORT = 1328;      
  public final static String SERVER = "127.0.0.1";  
  public final static String
       FILE_NAME = "xyz.txt";  
  public final static String
       ZIP_FILE_NAME = "xyz.zip";  
  public final static String
       FILE_PATH = "c:/temp/";  

  public final static int FILE_SIZE = 6022386; 

  public static void main (String [] args ) throws IOException {
    int bytesRead;
    int current = 0;
    FileOutputStream fos = null;
    BufferedOutputStream bos = null;
    Socket sock = null;
    try {
      sock = new Socket(SERVER, SOCKET_PORT);
      System.out.println("Connecting...");

      // receive file
      byte [] mybytearray  = new byte [FILE_SIZE];
      InputStream is = sock.getInputStream();
      fos = new FileOutputStream(FILE_PATH+ZIP_FILE_NAME);
      bos = new BufferedOutputStream(fos);
      bytesRead = is.read(mybytearray,0,mybytearray.length);
      current = bytesRead;

      do {
         bytesRead =
            is.read(mybytearray, current, (mybytearray.length-current));
         if(bytesRead >= 0) current += bytesRead;
      } while(bytesRead > -1);

      bos.write(mybytearray, 0 , current);
      bos.flush();
      System.out.println("File " + FILE_PATH+ZIP_FILE_NAME
          + " downloaded (" + current + " bytes read)");
    }
    finally {
      if (fos != null) fos.close();
      if (bos != null) bos.close();
      if (sock != null) sock.close();
    }

    unZipIt();

  }



  public static void unZipIt(){

     byte[] buffer = new byte[1024];

     try{

        //get the zip file content
        ZipInputStream zis = 
        new ZipInputStream(new FileInputStream(FILE_PATH+ZIP_FILE_NAME));
        //get the zipped file list entry
        ZipEntry ze = zis.getNextEntry();

        while(ze!=null){

           String fileName = ze.getName();
           File newFile = new File(FILE_PATH+FILE_NAME);

           System.out.println("file unzip : "+ newFile.getAbsoluteFile()); 
           FileOutputStream fos = new FileOutputStream(newFile);             

            int len;
            while ((len = zis.read(buffer)) > 0) {
            fos.write(buffer, 0, len);
            }

            fos.close();   
            ze = zis.getNextEntry();
        }

        zis.closeEntry();
        zis.close();
        System.out.println("Done");

    }catch(IOException ex){
       ex.printStackTrace(); 
    }
   }    



}