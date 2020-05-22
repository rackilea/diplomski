lexer grammar JavaCommentLexer;

options {
  filter=true;
}

SingleLineComment
  :  FSlash FSlash ~('\r' | '\n')*
  ;

MultiLineComment
  :  FSlash Star .* Star FSlash
  ;

StringLiteral
  :  DQuote
     ( (EscapedDQuote)=> EscapedDQuote
     | (EscapedBSlash)=> EscapedBSlash
     | Octal
     | Unicode
     | ~('\\' | '"' | '\r' | '\n')
     )*
     DQuote {skip();}
  ;

CharLiteral
  :  SQuote
     ( (EscapedSQuote)=> EscapedSQuote
     | (EscapedBSlash)=> EscapedBSlash
     | Octal
     | Unicode
     | ~('\\' | '\'' | '\r' | '\n')
     )
     SQuote {skip();}
  ;

fragment EscapedDQuote
  :  BSlash DQuote
  ;

fragment EscapedSQuote
  :  BSlash SQuote
  ;

fragment EscapedBSlash
  :  BSlash BSlash
  ;

fragment FSlash
  :  '/' | '\\' ('u002f' | 'u002F')
  ;

fragment Star
  :  '*' | '\\' ('u002a' | 'u002A')
  ;

fragment BSlash
  :  '\\' ('u005c' | 'u005C')?
  ;

fragment DQuote
  :  '"' 
  |  '\\u0022'
  ;

fragment SQuote
  :  '\'' 
  |  '\\u0027'
  ;

fragment Unicode
  :  '\\u' Hex Hex Hex Hex
  ;

fragment Octal
  :  '\\' ('0'..'3' Oct Oct | Oct Oct | Oct)
  ;

fragment Hex
  :  '0'..'9' | 'a'..'f' | 'A'..'F'
  ;

fragment Oct
  :  '0'..'7'
  ;