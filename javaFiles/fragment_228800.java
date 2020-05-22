public class RegexpMatch {
    static Pattern Regex = Pattern.compile(
            "([A-Za-z][A-Za-z0-9.\\-_]*)\\s*(at)\\s*(([A-Za-z][A-Za-z0-9\\-_()]*\\s*(dot)\\s*)+[A-Za-z]+)"
        );

    public static void main( final String[] args ){
        final String[] tests = {
                "abcdatcsdotuniversitydotedu",
                "abcd at cs dot university dot edu"
        };

        for ( final String test : tests )
            System.out.println( test + " - "  + ( Regex.matcher( test ).matches() ? "Match" : "No Match" ) );
    }
}