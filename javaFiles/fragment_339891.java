pid
  : PID EQ (word|POINT)+
  ;

log
  : LOG EQ (word|POINT)+
  ;

word
  : WORD
  | PID
  | LOG 
  ;