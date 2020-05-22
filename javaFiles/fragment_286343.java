final CharArraySet defaultStopwords = new ItalianAnalyzer(Version.LUCENE_47).getStopWordSet();

final CharArraySet defaultArticles = CharArraySet.unmodifiableSet(
   new CharArraySet(Version.LUCENE_CURRENT, 
       Arrays.asList(
      "c", "l", "all", "dall", "dell", "nell", "sull", "coll", "pell", 
       "gl", "agl", "dagl", "degl", "negl", "sugl", "un", "m", "t", "s", "v", "d"
       ), true));

Analyzer customItalianAnalyzer = new Analyzer() {
  @Override
  protected TokenStreamComponents createComponents(String fieldName, Reader reader) {
    final Tokenizer source = new StandardTokenizer(Version.LUCENE_47, reader);
    TokenStream result = new StandardFilter(Version.LUCENE_47, source);
    result = new ElisionFilter(result, defaultArticles);
    result = new LowerCaseFilter(Version.LUCENE_47, result);
    result = new StopFilter(Version.LUCENE_47, result, defaultStopwords);
    return new TokenStreamComponents(source, result);
  }
};