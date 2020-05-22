lexer grammar TestLexer;

LBR: '[' -> pushMode(InString);

mode InString;

STRING : ([a-z] | '\\]' | '[')+ ;
RBR: ']' -> popMode;