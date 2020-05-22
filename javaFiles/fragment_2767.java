grammar T;

parse
  :  statement+ EOF
  ;

statement
  :  var_dec
  |  statement_blocks
  |  c=condition_statement {System.out.println("parsed :: " + $c.text);}
  ;

var_dec
  :  ID '=' ID ';'
  ;

statement_blocks
  :  LBRACE statement* RBRACE
  ;

condition_statement 
  :  IF LPAREN expr RPAREN statement (options {greedy=true;}: ELSE statement)?
  ;

expr
  :  ID '==' ID
  ;

IF     : 'if';
ELSE   : 'else';
ID     : 'a'..'z'+;
LBRACE : '{';
RBRACE : '}';
LPAREN : '(';
RPAREN : ')';
SPACE  : (' ' | '\t' | '\r' | '\n')+ {skip();};