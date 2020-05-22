import java.io.InputStream;

public class CmdProxy {
  public static void main(String [] args) {
    try {
        Process proc = Runtime.getRuntime().exec("cmd /C \"dir \\ \"");
        InputStream is = proc.getInputStream();

        // NOTE: this is not the most elegant way to extract content from the
        // input stream
        int i = -1;
        StringBuilder buf = new StringBuilder();
        while ((i = is.read()) != -1) {
            buf.append((char)i);
        }

        proc.waitFor();

        System.out.println(buf.toString());
    } catch (Throwable t) {
        t.printStackTrace();
    }
  }
}