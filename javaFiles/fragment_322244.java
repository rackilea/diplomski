grammar list;

list
 : BEGL elems? ENDL
 ;

elems
 : elem ( SEP elem )*
 ;

elem
 : NUM
 ;

BEGL : '[';
ENDL : ']';
SEP  : ',';
NUM  : [0-9]+;
WS   : [ \t\r\n]+ -> skip;