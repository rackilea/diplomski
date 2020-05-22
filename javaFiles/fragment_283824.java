public String pad(String source, int targetLength, String pad) {
  StringBuilder result = new StringBuilder( source );    
  while( result.length() < targetLength ) {
    result.append(pad.substring( 0, Math.min( pad.length(), targetLength -  result.length() ) ));
  }
  return result.toString();
}