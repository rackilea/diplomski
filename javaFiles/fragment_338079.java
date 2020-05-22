import org.antlr.runtime.*;

public class Main {
  public static void main(String[] args) throws Exception {
    System.out.println(TParser.matches(""));
    System.out.println(TParser.matches("1 234 42"));
    System.out.println(TParser.matches("12 556 f"));
  }
}