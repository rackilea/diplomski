import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;

public static boolean isExpr(String exp) {

    ExprLexer lexer = new ExprLexer(new ANTLRInputStream(exp));
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    ExprParser parser = new ExprParser(tokens);

    parser.removeErrorListeners();
    parser.setErrorHandler(new BailErrorStrategy());

    try {
        parser.expr();
        return true;
    }  catch (ParseCancellationException e) {
        return false;
    }

}