SINGLELINE_COMMENT
 : '//' ~('\r' | '\n')* {$channel=HIDDEN;}
 ;

WS 
 : (' '|'\r'|'\t'|'\u000C'|'\n')+ {$channel=HIDDEN;}
 ;