grammar T;

options {
  output=AST;
  ASTLabelType=CommonTree;
}

tokens {
  TRANSITIONS;
  PAIR;
}

parse
 : transitions EOF!
   {
     CommonTree root = $transitions.tree;

     int count = root.getChildCount();

     Tree child1 = root.getChild(0);
     Tree child2 = root.getChild(1);
     Tree child3 = root.getChild(2);
     Tree child4 = root.getChild(3);

     System.out.println("root=" + root.getToken().getText() + " has " + count + " child nodes:");
     System.out.println(" - child1=" + child1.toStringTree());
     System.out.println(" - child2=" + child2.toStringTree());
     System.out.println(" - child3=" + child3.toStringTree());
     System.out.println(" - child4=" + child3.toStringTree());

     String secondValueFromLastPair = child4.getChild(1).getText();
     System.out.println("\nsecondValueFromLastPair=" + secondValueFromLastPair);
   }
 ;

transitions
 : 'transitions' '=' INT pair+ ';' -> ^(TRANSITIONS INT pair+)
 ;

pair
 : '(' INT ',' INT ')' -> ^(PAIR INT INT)
 ;

INT   : '0'..'9'+;
SPACE : ' ' {skip();};