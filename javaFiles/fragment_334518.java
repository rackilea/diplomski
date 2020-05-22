import org.antlr.v4.runtime.*;

public class Main {

  public static void main(String[] args) {

    String source = "87uuujdhhfj12ooiik56iijtg40jhdksa";

    TLexer lexer = new TLexer(CharStreams.fromString(source));
    CommonTokenStream tokens = new CommonTokenStream(lexer);

    tokens.fill();

    for (Token t : tokens.getTokens()) {
      System.out.printf("%-15s '%s'\n", TLexer.VOCABULARY.getSymbolicName(t.getType()), t.getText());
    }
  }
}