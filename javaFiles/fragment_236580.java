grammar Expressions;

expressions 
    :   expression+ EOF
    ;

expression 
    :   intExpression
    |   intListExpression
    |   floatExpression
    |   floatListExpression
    |   textExpression
    |   textListExpression
    ;

intExpression        :  intType INT;
intListExpression    :  intType listType '[' ( INT (',' INT)* )? ']';
floatExpression      :  floatType FLOAT;
floatListExpression  :  floatType listType '[' ( (INT|FLOAT) (',' (INT|FLOAT))* )? ']';
textExpression       :  textType STRING;
textListExpression   :  textType listType '[' ( STRING (',' STRING)* )? ']';

intType   :  'int';
floatType :  'float';
textType  :  'text';
listType  :  'list';

INT :   '0'..'9'+
    ;

FLOAT
    :   ('0'..'9')+ '.' ('0'..'9')* EXPONENT?
    |   '.' ('0'..'9')+ EXPONENT?
    |   ('0'..'9')+ EXPONENT
    ;

STRING
    :  '"' ( ESC_SEQ | ~('\\'|'"') )* '"'
    ;

fragment
EXPONENT : ('e'|'E') ('+'|'-')? ('0'..'9')+ ;

fragment
HEX_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F') ;

fragment
ESC_SEQ
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
    |   UNICODE_ESC
    |   OCTAL_ESC
    ;

fragment
OCTAL_ESC
    :   '\\' ('0'..'3') ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7')
    ;

fragment
UNICODE_ESC
    :   '\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
    ;

WS  :   ( ' '
        | '\t'
        | '\r'
        | '\n'
        ) {$channel=HIDDEN;}
    ;