String input = "website=http://google.com ping=http://pong.com website=http://stackoverflow.com";

Pattern p = Pattern.compile( "website=(\\S+)" );
Matcher m = p.matcher( input );

while( m.find() )
{
  System.out.println(m.group(1));
}