String input = ...
StringBuilder builder = new StringBuilder();

for( int i = 0; i < input.length(); i += 2 )
{
   //guard against odd text lengths
   if( i+1 < input.length() )
   {
      builder.append( input.charAt(i+1) );
   }   
   builder.append( input.charAt(i) );
}

String flippedText = builder.toString();