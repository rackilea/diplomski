int Exp() :{
    Token t;
    int value;}
{
    t = <TK_ID> 
    { 
        Integer v = TableVariables.getValue(t.image) ;
        if( v == null ) {
            reportError( "Uninitialized variable "+ t.image ) ;
            return 0 ;
        else {
            return v.intValue() ; }
    }
|
    t = <TK_INT_LITERAL> 
    { return Integer.parseInt( t.image, 10) ; }
|
   ...
}