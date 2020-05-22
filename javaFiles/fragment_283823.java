public String pad(String source, int targetLength, String pad) {
  StringBuilder result = new StringBuilder( source );
  for( int i = source.length(); i < targetLength; i+=pad.length() ) {
    result.append(pad);
  }
  return result.toString();
}

//calling:
a = pad( a, 32, "." );