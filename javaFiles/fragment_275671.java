grammar Hello;

parse
 : .*? EOF
 ;

INTEGER
 : [0-9]+
 ;

IDENTIFIER
 : [a-zA-Z_]+
 ;

SINGLE_LINE_COMMENT
 : '--' ~[\r\n]* -> skip
 ;

SPACES
 : [ \t\r\n]+ -> skip
 ;

OTHER
 : .
 ;