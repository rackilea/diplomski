grammar PDDL;

parse
  :  number+ EOF
  ;

number
  :  Hex
  |  Dec
  |  Oct
  ;

Hex
  :  '0' ('x' | 'X') ('0'..'9' | 'a'..'f' | 'A'..'F')+
  ;

Dec
  :  '0'
  |  '1'..'9' ('0'..'9')*
  ;

Oct
  :  '0' '0'..'7'+
  ;

Space
  :  (' ' | '\t' | '\r' | '\n'){$channel=HIDDEN;}
  ;