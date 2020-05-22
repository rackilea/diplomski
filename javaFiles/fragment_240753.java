import java.io.*;
import java.util.*;
/**
 *
 * @author Selva
 */
public class Readfile {
  public static void main(String[] args) throws FileNotFoundException, IOException{
   if (args.length==0)
   {
     System.out.println("Error: Bad command or filename.");
     System.exit(0);
   }else {
       InputStream in = new FileInputStream(new File(args[0]));
       OutputStream out = new FileOutputStream(new File(args[1]));
      byte[] buf = new byte[1024];
      int len;
      while ((len = in.read(buf)) > 0) {
         out.write(buf, 0, len);
      }
      in.close();
      out.close();
   }   
  }  
}