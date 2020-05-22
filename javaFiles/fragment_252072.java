String text = ...; // your text
Pattern pat = Pattern.compile( "『([^』]*)』" );
Matcher mat = pat.matcher( text );
if( mat.find() ){
    System.out.println( mat.group(1) );
}