String current = input.next();
int openIndex = current.indexOf( "<" );
if( openIndex > -1 )
{
    int closeIndex = current.indexOf( ">" );
    current = current.substring( openIndex + 1, closeIndex - openIndex );
}
System.out.println( current );