import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import org.antlr.stringtemplate.*;

public class Main {
  public static void main(String[] args) throws Exception {
    String source = "array[2*3]";
    testLexer lexer = new testLexer(new ANTLRStringStream(source));
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    testParser parser = new testParser(tokens);
    testParser.start_return returnValue = parser.start();
    CommonTree tree = (CommonTree)returnValue.getTree();
    DOTTreeGenerator gen = new DOTTreeGenerator();
    StringTemplate st = gen.toDOT(tree);
    System.out.println(st);
  }
}