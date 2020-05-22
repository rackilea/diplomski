import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Test {
  public static void main(String[] args) throws InterruptedException {


    byte[] contents = new byte[1024];
    InputStream inStream = Test.class.getClassLoader().getResourceAsStream("abc.xslt");
    BufferedInputStream bis = new BufferedInputStream(inStream);

    int bytesRead=0;
    String strFileContents = null;
    try {
      while( (bytesRead = bis.read(contents)) != -1){
        strFileContents = new String(contents, 0, bytesRead);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.print(strFileContents);
  }
}