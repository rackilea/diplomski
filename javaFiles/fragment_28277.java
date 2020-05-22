import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import org.antlr.stringtemplate.*;

public class Main {
  public static void main(String[] args) throws Exception {

    // the expression
    String src = "(P || Q || R) && ((P -> R) -> Q)";

    // create a lexer & parser
    LogicLexer lexer = new LogicLexer(new ANTLRStringStream(src));
    LogicParser parser = new LogicParser(new CommonTokenStream(lexer));

    // invoke the entry point of the parser (the parse() method) and get the AST
    CommonTree tree = (CommonTree)parser.parse().getTree();

    // print the DOT representation of the AST 
    DOTTreeGenerator gen = new DOTTreeGenerator();
    StringTemplate st = gen.toDOT(tree);
    System.out.println(st);
  }
}