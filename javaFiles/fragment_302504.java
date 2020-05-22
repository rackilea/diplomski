package parseTest;

import org.antlr.runtime.*;

public class Main {
  public static void main(String[] args) throws Exception {
    SmallTestLexer lexer = new SmallTestLexer(new ANTLRStringStream("a bb ccc\ndddd eeeee\n"));
    SmallTestParser parser = new SmallTestParser(new CommonTokenStream(lexer));
    System.out.println(parser.prog());
  }
}