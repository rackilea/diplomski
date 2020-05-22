Pattern p = Pattern.compile("([-+]?[0-9]*\\.?[0-9]+)");
Matcher m = p.matcher("some string and then a number 123.456789 and continue");

if ( m.find() ) {
  System.out.println(m.group(1)); // 123.456789
}