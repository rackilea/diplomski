import org.antlr.runtime.*;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        File source = new File("source.txt");
        ANTLRInputStream in = new ANTLRInputStream(new FileInputStream(source));
        PDDLLexer lexer = new PDDLLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PDDLParser parser = new PDDLParser(tokens);
        parser.parse();
    }
}