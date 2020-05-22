import java.io.*;

public class Test {


       public static void main(String[] arg) throws Throwable {
          File f = new File(arg[0]);
          InputStream in = new FileInputStream(f);

          byte[] buff = new byte[8000];

          int bytesRead = 0;

          ByteArrayOutputStream bao = new ByteArrayOutputStream();

          while((bytesRead = in.read(buff)) != -1) {
             bao.write(buff, 0, bytesRead);
          }

          byte[] data = bao.toByteArray();

          ByteArrayInputStream bin = new ByteArrayInputStream(data);
          System.out.println(bin.available());
       }
}