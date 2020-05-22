file : prop+ EOF ;
prop : ID '=' STRING NEWLINE ;

ID      : [a-zA-Z]+ ;
STRING  : { isValue() }? (~[\r\n])+; 
NEWLINE : '\r'?'\n' ;