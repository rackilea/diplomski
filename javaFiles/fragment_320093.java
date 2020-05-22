package demo;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

public class Main {

  public static void main(String[] args) throws Exception {
    String source = "12    +  42 ;";
    TLexer lexer = new TLexer(new ANTLRStringStream(source));
    TParser parser = new TParser(new CommonTokenStream(lexer));
    parser.setTreeAdaptor(new CommonTreeAdaptor(){
      @Override
      public Object create(Token t) {
        return new XTree(t);
      }
    }); 
    XTree root = (XTree)parser.parse().getTree();
    System.out.println("tree    : " + root.toStringTree());
    System.out.println("matched : " + root.matched);    
  }
}