import java.io.*;
import org.apache.commons.codec.binary.Base64InputStream;

class tmp {
  public static void main(String[] args) throws IOException {
    FileInputStream fis = new FileInputStream(args[0]);
    Base64InputStream b64is = new Base64InputStream(fis, true, -1, null);

    while (true) {
      byte[] c = new byte[1024];
      int n = b64is.read(c);
      if (n < 0) break;
      if (n == 0) throw new IOException("returned 0!");
      for (int i = 0; i < n; i++) {
        System.out.print((char)c[i]);
      }
    }
  }
}