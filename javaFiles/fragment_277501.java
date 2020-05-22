grammar T;

args       : (typedident (COMMA typedident)*)? EOF;
typedident : (INT | CHAR) IDENT;

COMMA : ',';
INT   : 'int';
CHAR  : 'char';
IDENT : ('a'..'z' | 'A'..'Z') ('a'..'z' | 'A'..'Z' | '0'..'9')*;
SPACE : ' ' {skip();};