grammar archie;
// Parser Rules

programme:  line* EOF;

line
 : element (';' | '\n')+
 | COMMENT
 ;

//assignment: identifier  EQ  element;

element
 : element  elementList         //Function Call
 | nameList  FARROW  element    //Function Literal
 | identifier                   //Identifier
 | element  (DOT NAME)+         //CombinedID
 | identifier EQ element        //assignment
 | O_C_BRACK (element (';' | '\n' | ';\n'))* C_C_BRACK
 | element NAME element
 ;


elementList: O_R_BRACK  element?  (COMMA  element)* C_R_BRACK;

identifier: NAME (DOT NAME)*;

nameList: O_R_BRACK (NAME COMMA)* (NAME COMMA?)? C_R_BRACK;

NAME
 : [A-Za-z_][A-Za-z0-9_]*
 | [~!$^*&+#<>?|]+
 ;

FARROW: '=>';
WS: [ \t]+ -> skip;
SKP: [\r]+ -> skip;
COMMENT: '//' ~[\n]* '\n'+;

DOT: '.';
COMMA: ',';

EQ: '=';

O_R_BRACK: '(';
C_R_BRACK: ')';
O_C_BRACK: '{';
C_C_BRACK: '}';