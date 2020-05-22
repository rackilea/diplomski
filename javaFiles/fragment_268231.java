public static String boom ( String s ) 
{ 
   if ( s.length ()> 5 ) { 
      s = s.substring ( 2 , 4 ); 
   }
   if ( s.length ()> 1 ) { 
      s = "" + s.charAt( 0 ) + s.charAt( s.length()- 1 );
   }
   return s; 
}