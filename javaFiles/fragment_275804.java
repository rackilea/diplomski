String in = "The quick brown fox \"jumped over\" the \"lazy\" dog";
Pattern p = Pattern.compile( "\"([^\"]*)\"" );
Matcher m = p.matcher( in );
while( m.find()) {
   System.err.println( m.group( 1 ));
}