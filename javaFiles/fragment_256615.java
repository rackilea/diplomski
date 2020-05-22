public static void main ( String args[] )
{
    String input = "text 3.454 sometext5.567568more_text";
    ArrayList < Double > myDoubles = new ArrayList < Double >();
    Matcher matcher = Pattern.compile( "[-+]?\\d*\\.?\\d+([eE][-+]?\\d+)?" ).matcher( input );

    while ( matcher.find() )
    {
        double element = Double.parseDouble( matcher.group() );
        myDoubles.add( element );
    }

    for ( double element: myDoubles )
        System.out.println( element );
}