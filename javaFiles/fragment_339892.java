pid
  : PID EQ FULL_WORD
  ;

log
  : LOG EQ FULL_WORD
  ;

// ...

FULL_WORD
  : WORD (POINT WORD)*
  ;

// ...