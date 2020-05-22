import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {

  static int nextInt(InputStream in) throws IOException {
    int ch;
    for (; (ch = in.read()) < '0' || ch > '9';);
    int c = ch - '0';
    for (; (ch = in.read()) <= '9' && ch >= '0'; c = c * 10 + ch - '0');
    return c;
  }

  public static void main(String[] args) throws IOException {

    InputStream in = new BufferedInputStream(System.in, 4096);
    int n = nextInt(in);
    int k = nextInt(in);
    int t = 0;
    for (int i = 0; i < n; i++) {
      if (nextInt(in) % k == 0) t++;
    }
    System.out.println(t);
  }
}