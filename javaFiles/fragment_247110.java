grammar Expression;

expression
 : expression op=( MUL | DIV ) expression #expressionMul
 | expression op=( ADD | MIN ) expression #expressionAdd
 | '(' expression ')'                     #expressionNested
 | NUMBER                                 #expressionNumber
 ;

MUL    : '*';
DIV    : '/';
ADD    : '+';
MIN    : '-';
NUMBER : [0-9]+ ( '.' [0-9]+ )?;
SPACE  : [ \t\r\n] -> skip;