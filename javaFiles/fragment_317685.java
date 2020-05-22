String strMain = "S1R2G3M1D1N3";
String str = "S1,,--R2,,,,D3-N3";
Pattern pattern = Pattern.compile( "[A-Z][0-9]" );
Matcher matcher = pattern.matcher( str );
while ( matcher.find() ) {
    if ( strMain.contains( matcher.group() ) ) {
        System.out.println( matcher.group() );
    }
}