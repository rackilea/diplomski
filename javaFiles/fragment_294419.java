grammar RL;

report
 : REPORT ('(' NAME ')')? BEGIN END
 ;

REPORT : 'Report';     
BEGIN  : 'Begin';
END    : 'End';
NAME   : LETTER (LETTER | DIGIT | '_')*;

fragment LETTER : LOWER | UPPER;
fragment LOWER  : 'a'..'z';
fragment UPPER  : 'A'..'Z';
fragment DIGIT  : '0'..'9';

SPACE  : (' ' | '\t' | '\r' | '\n')+ { $channel = HIDDEN; };