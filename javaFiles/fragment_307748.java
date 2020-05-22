grammar test1;  // different name for my test rig
test1: ARRAY_NAME L_RIGHT_PAR (ARRAY_DIGIT|STRING) R_RIGHT_PAR;
ARRAY_DIGIT:DIGIT+; 
ARRAY_NAME: '&''COL';
STRING  : QUOT ('\\"' | ~'"')* QUOT
    ;
QUOT: '"'; // assumed this
L_RIGHT_PAR : '[' ;
R_RIGHT_PAR : ']' ;
fragment
DIGIT : '0'..'9' ;
WS : [ \t\r\n] -> skip;  // added whitespace just so I could add \r\n