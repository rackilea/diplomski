import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;

public class Main {
    public static void main(String[] args) throws IOException {
        CharStream s = new ANTLRFileStream("Input.javaX");
        JavaLexer lexer = new JavaLexer(s);
        TokenStream t = new CommonTokenStream(lexer);
        int i = 1;
        while (true) {
            if (t.LA(i) == -1) {
                break;
            }
            if (t.LA(i) == JavaLexer.IMPORT) {
                System.out.print("import ");
            } else {
                System.out.print(t.LT(i).getText() + " ");
            }
            i++;
        }
    }
}