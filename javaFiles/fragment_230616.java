import org.antlr.runtime.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    String input = "A 12 34\n" +
                   "B 5 6 7 8\n" +
                   "C 9";
    TLexer lexer = new TLexer(new ANTLRStringStream(input));
    TParser parser = new TParser(new CommonTokenStream(lexer));
    Map<String, List<Integer>> values = parser.parse();
    System.out.println(values);
  }
}