transitions
 : ^(TRANSITIONS INT pair+) {System.out.println("transitions.INT=" + $INT.text);}
 ;

pair
 : ^(PAIR a=INT b=INT) {System.out.println("pair=" + $a.text + ", " + $b.text);}
 ;