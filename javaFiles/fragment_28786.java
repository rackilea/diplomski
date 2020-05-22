expr
    : value                                 # argumentArithmeticExpr
    | (PLUS|MINUS) expr                     # plusMinusExpr
    | l=expr operator=(MULT|DIV) r=expr     # multdivArithmeticExpr
    | l=expr operator=(PLUS|MINUS) r=expr   # addsubtArithmeticExpr
    | function=IDENTIFIER '(' (expr ( COMMA  expr )* ) ? ')'# functionExpr
    | '(' expr ')'           # parensArithmeticExpr
    ;