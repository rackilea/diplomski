import org.antlr.runtime.*;

public class Main {
    public static void main(String[] args) throws Exception {
        String source = args[0];         
        ANTLRStringStream in = new ANTLRStringStream(source);
        KLexer lexer = new KLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        KParser parser = new KParser(tokens);
        parser.expr();
    }
}