String strMain = "S1R2G3M1D1N3";
String str = "S.,,--R2...o,,,D3-N3',N3''";
Pattern pattern = Pattern.compile( "([A-Z][0-9]?)(?:\\.{1,2}|'{1,2})?" );
Matcher matcher = pattern.matcher( str );
while ( matcher.find() ) {
    if ( strMain.contains( matcher.group( 1 ) ) ) {
        System.out.println( matcher.group( 0 ) );
    }
}