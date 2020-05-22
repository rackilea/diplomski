import org.antlr.runtime.*;

public class Main {
  public static void main(String[] args) throws Exception {
    JavaCommentLexer lexer = new JavaCommentLexer(new ANTLRFileStream("Test.java"));
    CommonTokenStream tokens = new CommonTokenStream(lexer);
      for(Object o : tokens.getTokens()) {
      CommonToken t = (CommonToken)o;
      if(t.getType() == JavaCommentLexer.SingleLineComment) {
        System.out.println("SingleLineComment :: " + t.getText().replace("\n", "\\n"));
      }
      if(t.getType() == JavaCommentLexer.MultiLineComment) {
        System.out.println("MultiLineComment  :: " + t.getText().replace("\n", "\\n"));
      }
    }
  }
}