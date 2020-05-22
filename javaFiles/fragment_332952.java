String current      = input.next();
String cstStrBefore = "";
String cstStrAfter  = "";
int openIndex = current.indexOf( "<" );
boolean var = ( openIndex > -1 );
if( var )
{
   int closeIndex = current.indexOf( ">" );
   cstStrBefore = current.substring( 0, openIndex );
   cstStrAfter  = current.substring( closeIndex + 1 );
   current      = current.substring( openIndex + 1, closeIndex - openIndex );
}