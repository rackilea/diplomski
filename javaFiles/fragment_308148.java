lexer grammar TLexer;

TEXT
 : ~[$]
 ;

FUNCTION_START
 : '$' -> pushMode(IN_FUNCTION), skip
 ;

mode IN_FUNCTION;
  FUNTION_NESTED : '$' -> pushMode(IN_FUNCTION), skip;
  ID             : [a-zA-Z_]+;
  PAR_OPEN       : '(';
  PAR_CLOSE      : ')' -> popMode;
  NUMBER         : [0-9]+;
  STRING         : '\'' ( ~'\'' | '\'\'' )* '\'';
  COMMA          : ',';
  SPACE          : [ \t\r\n]-> skip;