grammar T;

options {
  language=C;
}

parse
  :  (t=. {printf("token: '\%s'\n", $t.text->chars);})+ EOF
  ;

NUMBER
  :  ('0'..'9')+ ('.' ('0'..'9')+)?
  ;

WORD
  :  ('a'..'z' | 'A'..'Z')+
  ;

OTHER
  :  .
  ;