tree grammar ExpWalker; // file: ExpWalker.g

options {
  tokenVocab=Exp; // use the tokens from Exp.g
  ASTLabelType=CommonTree;
}

eval returns [ExpNode e]
  :  exp {e = $exp.e;}
  ;

exp returns [ExpNode e]
  :  ^(Add a=exp b=exp) {e = new AddExp($a.e, $b.e);}
  |  ^(Sub a=exp b=exp) {e = new SubExp($a.e, $b.e);}
  |  ^(Mul a=exp b=exp) {e = new MulExp($a.e, $b.e);}
  |  ^(Div a=exp b=exp) {e = new DivExp($a.e, $b.e);}
  |  ^(U_SUB a=exp)     {e = new UnaryExp($a.e);}
  |  Number             {e = new NumberExp($Number.text);}
  ;