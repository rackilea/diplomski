lexer grammar FuzzyJavaLexer;

options{filter=true;}

SingleLineComment
  :  '//' ~( '\r' | '\n' )*
  ;

MultiLineComment
  :  '/*' .* '*/'
  ;

StringLiteral
  :  '"' ( '\\' . | ~( '"' | '\\' ) )* '"'
  ;

CharLiteral
  :  '\'' ( '\\' . | ~( '\'' | '\\' ) )* '\''
  ;