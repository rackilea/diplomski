void date() throws AnException : {
    Token t ;
    int m;
    int d ;
}{
    t=<CONSTANT>   { d = Integer.parse(t.image) ; }
    <SLASH>
    t=<CONSTANT>   { m = Integer.parse(t.image) ; }
    {   if( m > 12 ) throw AnException() ;
        if( d > 31 ) throw AnException() ;
    }
 }