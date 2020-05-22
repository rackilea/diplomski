grammar PDDL;

parse returns [List<Integer> list]
@init{$list = new ArrayList<Integer>();}
  :  (number {$list.add($number.value);})+ EOF
  ;

number returns [Integer value]
  :  Hex {$value = Integer.parseInt($Hex.text.substring(2), 16);}
  |  Dec {$value = Integer.parseInt($Dec.text);}
  |  Oct {$value = Integer.parseInt($Oct.text, 8);}
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