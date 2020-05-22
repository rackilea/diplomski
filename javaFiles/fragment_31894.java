String[] keywords = s.getKeywords();

for( String word : keywords ) {

  if( word.equals( keyword ) ) {

    key.add(s);
    break;
  }
}