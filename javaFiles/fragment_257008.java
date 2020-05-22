public final class YourAnalyzer extends ReusableAnalyzerBase { 

  @Override
  protected TokenStreamComponents createComponents(final String fieldName, final Reader reader) {
    final TokenStream source = new KeywordTokenizer(reader);
    return new TokenStreamComponents(source, new LowercaseFilter(Version.LUCENE_36, source));
  }
}