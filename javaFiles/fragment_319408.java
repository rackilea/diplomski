grammar Exp; // file: Exp.g

eval
  :  exp EOF
  ;

exp 
  :  addExp 
  ;

addExp
  :  mulExp ((Add | Sub) mulExp)*
  ;

mulExp
  :  unaryExp ((Mul | Div) unaryExp)*
  ;

unaryExp
  :  Sub atom
  |  atom
  ;

atom
  :  Number
  |  '(' exp ')'
  ;

Add    : '+';
Sub    : '-';
Mul    : '*';
Div    : '/';
Number : '0'..'9'+;
Space  : ' ' {skip();};