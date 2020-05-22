final static String str = "<spring:message code=\"common.about.team1\" />";
final static Pattern pattern = Pattern.compile( "\"(.+?)\"" );
final static Matcher matcher = pattern.matcher( str );

public static void main( String[] args )
{
    while ( matcher.find() )
    {
        System.out.println( matcher.group( 1 ) );
    }
}