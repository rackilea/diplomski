if( "uno".equals(separated[0]) ){
   String info = "";
   for( int i=1; i<separated.length; i++ ){
      info += separated[i];
      if( (i+1) < separated.length ){
         info += "="; // This replaces the user input '=' that you split out
      }
   }
   // After this loop info has the exact String the user entered even if it contained your delimiter ('=' in this example)
}