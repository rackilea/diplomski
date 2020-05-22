List<String> newList = new ArrayList<String>();
for( String s : yourArray ){
  while( s.startsWith( " " ) ){
    newList.add( "" );
    s = s.substring( 1 );
  }

  int indexToAddValue = newList.size();

  while( s.endsWith( " " ) ){
    newList.add( "" );
    s = s.substring( 0, s.length() - 1 );
  }

  newList.add( indexToAddValue, s );
 }
 String[] newArray = newList.toArray( String[] );