Analyzer analyzer = new Analyzer() {
 @Override
  protected TokenStreamComponents createComponents(String fieldName, Reader reader) {
    Tokenizer source = new FooTokenizer(reader); //ex. StandardAnalyzer
    TokenStream filter = new FooFilter(source); //ex. StandardFilter, LowercaseFilter, StopFilter, etc.
    filter = new BarFilter(filter);
    filter = new LengthFilter(true, filter, 3, Integer.MAX_VALUE);
    return new TokenStreamComponents(source, filter);
  }
};