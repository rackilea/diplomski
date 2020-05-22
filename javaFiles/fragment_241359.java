import org.antlr.runtime.*;

public class FuzzyJavaLexerTest {
    public static void main(String[] args) throws Exception {
        String source = 
            "class Test {                                 \n"+
            "  String s = \" ... \\\" // no comment \";   \n"+
            "  /*                                         \n"+
            "   * also no comment: // foo                 \n"+
            "   */                                        \n"+
            "  char quote = '\"';                         \n"+
            "  // yes, a comment, finally!!!              \n"+
            "  int i = 0; // another comment              \n"+
            "}                                            \n";
        System.out.println("===== source =====");
        System.out.println(source);
        System.out.println("==================");
        ANTLRStringStream in = new ANTLRStringStream(source);
        FuzzyJavaLexer lexer = new FuzzyJavaLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        for(Object obj : tokens.getTokens()) {
            Token token = (Token)obj;
            if(token.getType() == FuzzyJavaLexer.SingleLineComment) {
                System.out.println("Found a SingleLineComment on line "+token.getLine()+
                        ", starting at column "+token.getCharPositionInLine()+
                        ", text: "+token.getText());
            }
        }
    }
}