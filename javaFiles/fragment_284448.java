// Call the API to parse your sentence.
List<TaggedWord> words = tagger.tagSentence( ... );

// For each word tagged in the sentence...
for( TaggedWord word : words ) {
  String tag = word.tag();

  // Check the part-of-speech directly, without having to parse the string.
  if( "NN".equalsIgnoreCase( tag ) ) {
    System.out.printf( "%s is a noun\n", word.word() );
  }
}