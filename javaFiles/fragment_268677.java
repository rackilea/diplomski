List<String> names = Arrays.asList( "a", "b", "a", "b", "c" );

int i = 0;
for( String n : names.subList( 0, names.size() - 1) ) {
  for( String s : names.subList( i + 1, names.size() ) ) {
    if( n.equals( s )) {
      return true;
    }
  }

  i++;
}