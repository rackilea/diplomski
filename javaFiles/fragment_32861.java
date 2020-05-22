grammar test;

program : vr DOT to DOT e 
        ;
e: be
 | be DOT top DOT be
 ;
be: FG 
  | FS
  | MC 
  ;
to: N
  | A 
  | EV
  ;
vr: ER 
  | FP 
  ;
top: B
  | AF
  ;
Whitespace : [ \t\r\n]+ ->skip 
           ;

DOT : '.'
    ;

A: 'A'|'a'
 ;

AF: 'AF'|'af'
 ;
N: 'N'|'n'
 ;
MC: 'MC'|'mc'
 ;
EV:'EV'|'ev'
 ;
FS: 'FS'|'fs'
 ;
FP: 'FP'|'fp'
 ;
FG: 'FG'|'fg'
 ;
ER: 'ER'|'er'
 ;
B: 'B'|'b'
 ;