tree grammar ExpWalker; // file: ExpWalker.g

options {
  tokenVocab=Exp; // use the tokens from Exp.g
  ASTLabelType=CommonTree;
}

eval
  :  exp
  ;

exp
  :  ^(Add exp exp)
  |  ^(Sub exp exp)
  |  ^(Mul exp exp)
  |  ^(Div exp exp)
  |  ^(U_SUB exp)
  |  Number
  ;