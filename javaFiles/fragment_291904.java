Matcher m = p.Matcher( InputText );
StringBuffer Result = new StringBuffer("");

while ( m.find() )
{
   Result.append( m.Group() + "\n" );
}