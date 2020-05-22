grammar Logic;

parse
  :  expression EOF
  ;

expression
  :  implication
  ;

implication
  :  or ('->' or)*
  ;

or
  :  and ('||' and)*
  ;

and
  :  not ('&&' not)*
  ;

not
  :  '~' atom
  |  atom
  ;

atom
  :  ID
  |  '(' expression ')'
  ;

ID    : ('a'..'z' | 'A'..'Z')+;
Space : (' ' | '\t' | '\r' | '\n')+ {$channel=HIDDEN;};