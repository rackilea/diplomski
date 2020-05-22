expr
 : (antExp {System.out.println($antExp.str);} )+
 ;

antExpr returns [String str]
 : '{' T '}' {$str = $T.text;}
 ;

T : 'foo';