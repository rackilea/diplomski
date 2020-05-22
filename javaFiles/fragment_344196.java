function boolean isValid( String s ){
   try {
       Double.valueOf( s );
       return true;
   } catch( Exception e ){
       return false;
   }
}

rule "check"
when
    SomethingMissing( isValid( answer ) )
then ... end