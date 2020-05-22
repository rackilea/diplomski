Pattern methodPattern = Pattern.compile("GET|get");
Matcher matcher = methodPattern.matcher( msg );

if ( matcher.find() )
{
  System.out.println("method: " + matcher.group());
}

if ( matcher.usePattern( Pattern.compile("\\s/([^\\s]*)") ).find() )
{
  System.out.println("resource: " + matcher.group(1));
}

if ( matcher.usePattern( Pattern.compile("HTTP|http") ).find() )
{
  System.out.println("protocol: " + matcher.group());
}

if ( matcher.usePattern( Pattern.compile("/(\\d\\.\\d)") ).find() )
{
  System.out.println("version: " + matcher.group(1));
}