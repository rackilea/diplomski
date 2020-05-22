import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import static org.antlr.v4.runtime.CharStreams.fromFileName;

public class launch{
public static void main(String[] args) {

    CharStream cs = fromFileName("program.txt");  //load the file
    gramLexer lexer = new gramLexer(cs);  //instantiate a lexer
    CommonTokenStream tokens = new CommonTokenStream(lexer); //scan stream for tokens
    gramParser parser = new gramParser(tokens);  //parse the tokens

    ParseTree tree = parser.start(); // parse the content and get the tree
    Mylistener listener = new Mylistener();

    ParseTreeWalker walker = new ParseTreeWalker();
    walker.walk(listener,tree);
}}