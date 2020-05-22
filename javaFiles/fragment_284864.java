String input = "HeKiLH2B6";
Pattern p = Pattern.compile("([A-Z][a-z]*)(\\d*)");    
Matcher m = p.matcher( input );

while(m.find()){
  String element = m.group( 1 );
  String cardinalityStr = m.group( 2 );
  int cardinality= 1;
  if( cardinalityStr != null && cardinalityStr .length() > 0)
  {
    cardinality= Integer.parseInt( cardinalityStr );
  }

  System.out.println( element + cardinality);
}