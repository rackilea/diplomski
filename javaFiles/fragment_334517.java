lexer grammar TLexer;

@members {
  int charsToConsume = 0;
}

TOKEN
 : ( {charsToConsume-- > 0}? [a-zA-Z0-9] )+
 | [a-zA-Z]+
 ;

INT
 : [0-9]+ {
     int n = Integer.parseInt(getText());
     if (n == 12) {
       this.charsToConsume = 12;
     }
   }
 ;