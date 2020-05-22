import org.antlr.runtime.*;

public class Main {
  public static void main(String[] args) throws Exception {
    TLexer lexer = new TLexer(new ANTLRFileStream("in.txt"));
    TParser parser = new TParser(new CommonTokenStream(lexer));
    parser.parse();
  }
}