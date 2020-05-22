grammar T;

parse
 : foo
 | bar
 | OTHER
 ;

foo : INT ;
bar : ALPHA ;

INT   : '0'..'9'+ ;
ALPHA : ('a'..'z' | 'A'..'Z')+ ;
OTHER : . ;