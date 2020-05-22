import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import org.antlr.stringtemplate.*;

public class Main {
  public static void main(String[] args) throws Exception {
    String src = 
        "select d from pool; \n" + 
        "set alias a.b.c.x d; \n" +
        "select d from pool;";
    TLexer lexer = new TLexer(new ANTLRStringStream(src));
    TParser parser = new TParser(new CommonTokenStream(lexer));
    CommonTree tree = (CommonTree)parser.parse().getTree();  
    DOTTreeGenerator gen = new DOTTreeGenerator();
    StringTemplate st = gen.toDOT(tree);
    System.out.println(st);
  }
}