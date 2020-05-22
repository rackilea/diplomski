String msg = "GET HTTP 200 OK"; //resource and protocol version are left out by purpose

Pattern pattern = Pattern.compile("(GET|get)?\\s(/[^\\s]*)?\\s(HTTP|http)?(/1\\.0)?");
Matcher matcher = pattern.matcher( msg );

while ( matcher.find() )
{
  System.out.println(matcher.group( 1 ));  //prints GET
  System.out.println(matcher.group( 2 ));  //prints null since there's no resource
  System.out.println(matcher.group( 3 ));  //prints HTTP
  System.out.println(matcher.group( 4 ));  //prints null since there's no version string
}