grammar RuleExp;

start
    :   statement+
    ;

statement
    :   assignment
    |   message
    |   ifElseExp
    |   switchExp
    ;

ifElseExp
    :   'if' '(' relCnd ')' 'then' '{' start '}'
    |   'if' '(' relCnd ')' 'then' '{' start '}' elseExp
    ;

elseExp
    :   'else' ifElseExp
    |   'else' '{' start '}'
    ;

switchExp
    :   'switch' '(' relCnd ')' caseExp
    ;

caseExp
    :   'case' terminal ':' '{' start '}' caseExp
    |   dfltExpr
    ;

dfltExpr
    :   'default' ':' '{' start '}'
    ;

message
    :   '@msg'Digit+
    ;

assignment
    :   id '=' addStmt
    ;

relCnd
    :   relCnd  '>' logCnd
    |   relCnd  '<' logCnd
    |   relCnd  '>=' logCnd
    |   relCnd  '<=' logCnd
    |   relCnd  '==' logCnd
    |   relCnd  '!=' logCnd 
    |   logCnd
    ;

logCnd
    :   logCnd  'AND'   termCnd
    |   logCnd  'OR'    termCnd
    |   logCnd  'XOR'   termCnd
    |   'NOT'   termCnd
    |   termCnd
    ;

addStmt
    :   addStmt '+' mulStmt
    |   addStmt '-' mulStmt
    |   mulStmt
    ;


mulStmt
    :   mulStmt '*' terminal
    |   mulStmt '/' terminal
    |   mulStmt '^' terminal
    |   terminal
    ;

terminal
    :   '('addStmt')'
    |   id
    |   number
    ;

termCnd
    :   '('relCnd')'
    |   id
    |   number
    ;

id
    :   '@prmt'(Digit)+
    |   '@fild'(Digit)+
    |   '@infF'(Digit)+
    |   '@mthd'(Digit)+
    |   '@cmpnt'(Digit)+
    |   '@oprt'(Digit)+
    |   Letter(Letter|Digit)*
    ;

number
    :   Digit+ ('.' Digit+)?
    ;

Letter
    :   'a'..'z'
    |   'A'..'Z'
    |   '_'
    ;

Digit
    :   '0'..'9'
    ;

WS  :   [ \t\r\n]+  ->  skip 
    ;