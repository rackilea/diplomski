package mypackage;

import java.io.FileInputStream;
import java.io.IOException;

import mypackage.JavaParser.MyMethodNameContext;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 * @author Leonardo Kenji Feb 4, 2014
 */
public class MyVisitor extends JavaBaseVisitor<Void> {

    /**
     * Main Method
     * 
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        ANTLRInputStream input = new ANTLRInputStream(new FileInputStream("/home/leoks/EclipseIndigo/workspace2/SO/src/mypackage/MyVisitor.java")); // we'll
                                                                                                                                                    // parse
                                                                                                                                                    // this
                                                                                                                                                    // file
        JavaLexer lexer = new JavaLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JavaParser parser = new JavaParser(tokens);
        ParseTree tree = parser.compilationUnit(); // see the grammar ->
                                                    // starting point for
                                                    // parsing a java file



        MyVisitor visitor = new MyVisitor(); // extends JavaBaseVisitor<Void>
                                                // and overrides the methods
                                                // you're interested
        visitor.visit(tree);
    }

    /**
     * some attribute comment
     */
    private String  someAttribute;

    @Override
    public Void visitMyMethodName(MyMethodNameContext ctx) {
        System.out.println("Method name:" + ctx.getText());
        return super.visitMyMethodName(ctx);
    }

}