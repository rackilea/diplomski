import org.antlr.runtime.*;

public class Main {
  public static void main(String[] args) throws Exception {
    PersonNamesMinimalLexer lexer = new PersonNamesMinimalLexer(new ANTLRStringStream(args[0]));
    PersonNamesMinimalParser parser = new PersonNamesMinimalParser(new CommonTokenStream(lexer));
    parser.parse();
  }
}