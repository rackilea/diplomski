rule: q=qualifiedName {System.out.println($q.text);};

qualifiedName
   :   
        i=Identifier { $i.setText($i.text + "_");}
        ('[' (qualifiedName+ | Integer)? ']')*
   ;

Identifier
    :   (   '_'
        |   '$'
        |   ('a'..'z' | 'A'..'Z')
        )
        ('a'..'z' | 'A'..'Z' | '0'..'9' | '_' | '$')*
    ;

Integer
    : Digit Digit*
    ;

fragment
Digit 
    : '0'..'9'
    ;