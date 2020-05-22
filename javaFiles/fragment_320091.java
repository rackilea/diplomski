grammar T;

options {
  output=AST;
  ASTLabelType=XTree;
}

@parser::header {
  package demo;
  import demo.*;
}

@lexer::header {
  package demo;
  import demo.*;
}

parse
 : expr EOF -> expr
 ;

expr
@after{$expr.tree.matched = $expr.text;}
 : Int '+' Int ';' -> ^('+' Int Int)
 ;

Int
 : '0'..'9'+
 ;

Space
 : ' ' {$channel=HIDDEN;}
 ;