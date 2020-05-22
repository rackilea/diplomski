expression
    : primary
    | expression '.' id
    ;

primary
    : id
    ;

id
    : Identifier
    | K_Return
    ;

// Better explicitly define them instead of litering keywords inside parser rules
K_Return
    : 'return'
    ;

Identifier
    : [a-zA-Z0-9_]+
    ;