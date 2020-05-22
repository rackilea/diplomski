grammar REPL;

parse
  :  programDeclaration EOF
  |  usesDeclaration EOF
  |  statement EOF
  ;

programDeclaration
  :  PROGRAM ID
  ;

usesDeclaration
  :  USES idList
  ;

statement
  :  ID '=' (INT | ID)
  ;

idList
  :  ID (',' ID)*
  ;

PROGRAM : 'program';
USES    : 'uses';
ID      : ('a'..'z' | 'A'..'Z' | '_') ('a'..'z' | 'A'..'Z' | '_' | '0'..'9')*;
INT     : '0'..'9'+;
SPACE   : (' ' | '\t' | '\r' | '\n') {skip();};