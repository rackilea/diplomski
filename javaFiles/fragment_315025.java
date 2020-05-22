import java.io.*;
import org.mozilla.javascript.CompilerEnvirons;
import org.mozilla.javascript.Parser;
import org.mozilla.javascript.ast.*;

public class PrintNodes {
  public static void main(String[] args) throws IOException {
    class Printer implements NodeVisitor {
      @Override public boolean visit(AstNode node) {
        String indent = "%1$Xs".replace("X", String.valueOf(node.depth() + 1));
        System.out.format(indent, "").println(node.getClass());
        return true;
      }
    }
    String file = "foo.js";
    Reader reader = new FileReader(file);
    try {
      CompilerEnvirons env = new CompilerEnvirons();
      env.setRecordingLocalJsDocComments(true);
      env.setAllowSharpComments(true);
      env.setRecordingComments(true);
      AstRoot node = new Parser(env).parse(reader, file, 1);
      node.visitAll(new Printer());
    } finally {
      reader.close();
    }
  }
}