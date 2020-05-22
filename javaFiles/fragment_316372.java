file : prop+ EOF ;
prop : ID STRING NEWLINE ;

ID      : [a-zA-Z]+ ;
STRING  : '=' (~[\r\n])+;
NEWLINE : '\r'?'\n' ;