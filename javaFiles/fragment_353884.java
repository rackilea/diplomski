public double getDoubleValue( String txt ) {
  double d = 0d;
  try {
    if( txt != null && !txt.isEmpty() ) {
      d = Double.parseDouble( txt );
    }
  } catch(Exception ex) {}
  return d;
}