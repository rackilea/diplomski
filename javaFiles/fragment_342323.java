while( ! author.empty() ){
  String f = file.pop();   // Note that in your code this is in the wrong place
  for( String aut: author.pop() ){
    Set<String> files = allInfo.get( aut );
    if( files == null ){
      files = new HashSet<>();
      allInfo.put( aut, files );
    }
    files.add( f );
  }
}