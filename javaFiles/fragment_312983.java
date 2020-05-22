transitions
 : 'transitions' '=' INT pair+ ';' -> ^(TRANSITIONS INT pair+)
 ;

pair
 : '(' INT ',' INT ')' -> ^(PAIR INT INT)
 ;