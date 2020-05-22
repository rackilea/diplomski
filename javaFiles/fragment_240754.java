import java.io.*;
import java.util.*;
    /**
     *
     * @author Selva
     */
    public class Readfile {
      public static void main(String[] args) throws FileNotFoundException, IOException{
       Scanner s=new Scanner(System.in);
       if (args.length==0)
       {
         System.out.println("Error: Bad command or filename.");
         System.exit(0);
       }else {
           System.out.println("Enter Input FileName");
           String a=s.nextLine();
           System.out.println("Enter Output FileName");
           String b=s.nextLine();
           InputStream in = new FileInputStream(new File(a));
           OutputStream out = new FileOutputStream(new File(b));
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