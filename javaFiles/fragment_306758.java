// input
String str = "reply <staticN123@sub1.mydomain.com";
// example 1
String nr0 = str.replaceAll( "^(?:.+<)?static[NMF](\\d+)@[a-z0-9_-]+\\.mydomain\\.com>?$", "$1" );
System.out.println( nr0 );
// example 2 (precompile regex is faster if it's used more than once afterwards)
Pattern p = Pattern.compile( "^(?:.+<)?static[NMF](\\d+)@[a-z0-9_-]+\\.mydomain\\.com>?$" );
Matcher m = p.matcher( str );
boolean b = m.matches();
String nr1 = m.group( 1 );  // m.group only available after m.matches was called
System.out.println( nr1 );