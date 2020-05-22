for ( int length = a.length; length > 0; length-- ) {
     for ( int i = 0; i + length < a.length; i++ ) {
         if ( b.contains(a.substring(i, i+length)) ) {
             //this is the biggest match
         }
     }
}