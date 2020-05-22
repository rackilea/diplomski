import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class Test {
    public static void main (String[] argv) throws UnsupportedEncodingException {
    String unicodeMessage =
    "\u7686\u3055\u3093\u3001\u3053\u3093\u306b\u3061\u306f";

    PrintStream out = new PrintStream(System.out, true, "UTF-8");
    out.println(unicodeMessage);
  }
}