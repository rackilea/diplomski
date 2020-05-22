private void myFunction(){
   int triesRemaining = MAX_TRIES;
   while( triesRemaining-- > 0 ){
      try{
         // ... do stuff
         return;
      }
      catch( Exception e ){
      }
   }
   throw new Exception( "too many failures" );
}