grammar Exparser;

parse
 : expr EOF
 ;

expr
 : expr binop expr
 | VARIABLE
 | '(' expr ')'
 ;

binop
 : AND | OR | EQUAL | LT | GT | LTE | GTE | NE
 ;

EQUAL     : '=' | 'EQ';
LT        : '<' | 'LT';
GT        : '>' | 'GT';
LTE       : '<=';
GTE       : '>=';
NE        : '!=' | 'NE';
AND       : 'AND' | '&' | 'and';
OR        : 'OR' | 'or';
VARIABLE  : [a-zA-Z0-9_.-]+;
SPACE     : [ \t\r\n] -> skip;