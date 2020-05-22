grammar Expr;       

expr:   FuncitonName '(' expr ')'
    |   '-' expr
    |   '(' expr ')'
    |   expr '*' expr
    |   expr '+' expr
    |   expr '-' expr
    |   expr '/' expr
    |   Const
    |   Variable
    ;

FuncitonName : [a-z] + ; 
Variable : [a-zA-Z] + ;
Const : [0-9] +;

WS  :  [ \t\r\n\u000C]+ -> skip;