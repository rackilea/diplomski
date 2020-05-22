grammar Exp; // file: Exp.g

options {
  output=AST;
}

tokens {
  U_SUB;
}

eval 
  :  exp EOF -> exp
  ;

exp 
  :  addExp 
  ;

addExp
  :  mulExp ((Add | Sub)^ mulExp)*
  ;

mulExp
  :  unaryExp ((Mul | Div)^ unaryExp)*
  ;

unaryExp
  :  Sub atom -> ^(U_SUB atom)
  |  atom
  ;

atom
  :  Number
  |  '(' exp ')' -> exp
  ;

Add    : '+';
Sub    : '-';
Mul    : '*';
Div    : '/';
Number : '0'..'9'+;
Space  : ' ' {skip();};