import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

public class Main {
  public static void main(String[] args) throws Exception {
    String src = "\n\n\nABC = 123\n\nstart ABC";
    ASTDemoLexer lexer = new ASTDemoLexer(new ANTLRStringStream(src));
    ASTDemoParser parser = new ASTDemoParser(new CommonTokenStream(lexer));
    CommonTree root = (CommonTree)parser.parse().getTree();
    ASTDemoWalker walker = new ASTDemoWalker(new CommonTreeNodeStream(root));
    walker.walk();
  }
}