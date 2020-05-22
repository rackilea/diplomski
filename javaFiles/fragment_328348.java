//non-ASCII
String yourstring = Arrays.toString(out).replaceAll("[^\\x00-\\x7F]", ".");


  //non-printable characters
String yourstring = Arrays.toString(out).replaceAll("\\p{C}", ".");