grammar ASTDemo;

options { 
  output=AST;
}

tokens {
  ROOT;
  ACTION;
}

parse
  :  sentence+ EOF -> ^(ROOT sentence+)
  ;

sentence
  :  assignCommand 
  |  actionCommand
  ;

assignCommand
  :  ID ASSIGN NUMBER -> ^(ASSIGN ID NUMBER)
  ;

actionCommand
  :  action ID -> ^(ACTION action ID)
  ;

action
  :  START
  |  STOP
  ;

ASSIGN : '=';
START  : 'start';
STOP   : 'stop';
ID     : ('a'..'z' | 'A'..'Z')+;
NUMBER : '0'..'9'+;
SPACE  : (' ' | '\t' | '\r' | '\n')+ {skip();};