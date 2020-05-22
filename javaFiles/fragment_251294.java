@Override
  protected TokenStreamComponents createComponents(final String fieldName) {
    final StandardTokenizer src = new StandardTokenizer();
    src.setMaxTokenLength(maxTokenLength);
    TokenStream tok = new LowerCaseFilter(src);
    tok = new StopFilter(tok, stopwords);
    return new TokenStreamComponents(r -> {
      src.setMaxTokenLength(StandardAnalyzer.this.maxTokenLength);
      src.setReader(r);
    }, tok);
  }