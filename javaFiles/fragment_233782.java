grammar Function;

parseFunction returns [java.util.List<java.util.List<Object>> list] :   
    { list = new java.util.ArrayList(); }                                              ( f=functionPart { list.add($f.list); } )+
|   { list = new java.util.ArrayList(); } ( fb=functionBegin ) { list.add($fb.list); } ( f=functionPart { list.add($f.list); } )*
;

functionBegin returns [java.util.List<Object> list]:
m=NUMBER v=VARIABLE e=exponent  { list = new java.util.ArrayList(); list.add("+"); list.add($m.text); list.add($v.text); list.add($e.value); }
| m=NUMBER v=VARIABLE           { list = new java.util.ArrayList(); list.add("+"); list.add($m.text); list.add($v.text); }
| v=VARIABLE e=exponent         { list = new java.util.ArrayList(); list.add("+"); list.add("1");     list.add($v.text); list.add($e.value); }  
| v=VARIABLE                    { list = new java.util.ArrayList(); list.add("+"); list.add("1");     list.add($v.text); }
| m=NUMBER                      { list = new java.util.ArrayList(); list.add("+"); list.add($m.text); }
;

functionPart returns [java.util.List<Object> list] :    
s=SIGN m=NUMBER v=VARIABLE e=exponent   { list = new java.util.ArrayList(); list.add($s.text); list.add($m.text); list.add($v.text); list.add($e.value); }
| s=SIGN m=NUMBER v=VARIABLE            { list = new java.util.ArrayList(); list.add($s.text); list.add($m.text); list.add($v.text); }
| s=SIGN v=VARIABLE e=exponent          { list = new java.util.ArrayList(); list.add($s.text); list.add("1");     list.add($v.text); list.add($e.value); }
| s=SIGN v=VARIABLE                     { list = new java.util.ArrayList(); list.add($s.text); list.add("1");     list.add($v.text); }
| s=SIGN m=NUMBER                       { list = new java.util.ArrayList(); list.add($s.text); list.add($m.text); }
;

exponent returns [int value]: ('^' n=INTEGER) { $value = 1; if ( $n != null && $n.text.length() > 0) $value = Integer.parseInt($n.text); }
;

VARIABLE    : ('a'..'z'|'A'..'Z')+
;

INTEGER : ('0'..'9')+
;

NUMBER  : ('0'..'9')+ (','('0'..'9')+)?
;

SIGN    :   ('+'|'-')
;

WS  :    (' ' | '\t' | '\r'| '\n')+ {skip();} 
;