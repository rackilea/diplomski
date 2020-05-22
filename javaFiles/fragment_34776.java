grammar T;

options {
  output=AST;
}

parse
  :  expr EOF!
  ;

expr
  :  factor
  ;

factor
  :  atom (options{greedy=true;}: ('*'^ | '/'^) atom)*
  ;

atom
  :  INT
  |  ':'^ expr
  ;

INT : ('0'..'9')+;