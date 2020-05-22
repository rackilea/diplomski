grammar test;

options {
  output=AST;
}

tokens {
  ARRAY_EXPR;
}

start      : expression;

expression : andExp;
andExp     : cmpExp (And^ cmpExp)*;
cmpExp     : sumExp (LessThan^ sumExp)*;
sumExp     : prodExp ((Plus | Minus)^ prodExp)*;
prodExp    : unaryExp (Times^ unaryExp)*;
unaryExp   :  '-' primaryExp
           |  '!' primaryExp // negation is really a `unaryExp`
           |  primaryExp
           ;

primaryExp : INT                  primaryPrime[null]?
           | 'true'               primaryPrime[null]?
           | 'false'              primaryPrime[null]?
           | 'this'               primaryPrime[null]?
           | (ID -> ID)           (primaryPrime[new CommonTree($ID)] -> primaryPrime)?
           | '('! expression ')'! primaryPrime[null]?
           ;

// removed the matching of 'epsilon'
primaryPrime [CommonTree parent]
           : '[' expression ']'             primaryPrime[null]? -> ^(ARRAY_EXPR {parent} expression primaryPrime?)
           | '.' ID '(' exprList? ')'       primaryPrime[null]?
           | '.length'                      primaryPrime[null]?
           | 'new' 'int' '[' expression ']' primaryPrime[null]?
           | 'new' ID '(' ')'               primaryPrime[null]?
           ;

// removed the matching of 'epsilon' 
exprList   : expression (',' expression)*;

// be sure to create explicit tokens for keywords!
True       : 'true';
False      : 'false';
This       : 'this';
LessThan   : '<';
Plus       : '+';
Minus      : '-';
Times      : '*';
And        : '&&';
Not        : '!';
INT        : '0' | ('1'..'9')('0'..'9')*;
ID         : ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
WS         : ('\t' | ' ' | '\r' | '\n'| '\u000C') { $channel=HIDDEN; } ;