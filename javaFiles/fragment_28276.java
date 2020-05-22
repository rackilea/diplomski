// save it in a file called Logic.g
grammar Logic;

options {
  output=AST;
}

// parser/production rules start with a lower case letter
parse
  :  expression EOF!    // omit the EOF token
  ;

expression
  :  implication
  ;

implication
  :  or ('->'^ or)*    // make `->` the root
  ;

or
  :  and ('||'^ and)*    // make `||` the root
  ;

and
  :  not ('&&'^ not)*      // make `&&` the root
  ;

not
  :  '~'^ atom    // make `~` the root
  |  atom
  ;

atom
  :  ID
  |  '('! expression ')'!    // omit both `(` and `)`
  ;

// lexer/terminal rules start with an upper case letter
ID    : ('a'..'z' | 'A'..'Z')+;
Space : (' ' | '\t' | '\r' | '\n')+ {$channel=HIDDEN;};