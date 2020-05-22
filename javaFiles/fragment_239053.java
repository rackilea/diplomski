@Override
protected TokenStreamComponents createComponents(final String fieldName) {
  final StandardTokenizer src = new StandardTokenizer();
  src.setMaxTokenLength(maxTokenLength);
  TokenStream tok = new StandardFilter(src);
  tok = new LowerCaseFilter(tok);
  tok = new StopFilter(tok, stopwords);
  tok = new CustomFilter(tok, opts); //Just adding this line
  return new TokenStreamComponents(src, tok) {
    @Override
    protected void setReader(final Reader reader) {
      src.setMaxTokenLength(StandardAnalyzer.this.maxTokenLength);
      super.setReader(reader);
    }
  };
}