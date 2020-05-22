public class PorterAnalyzer extends Analyzer {
  @Override
  @SuppressWarnings("resource")
  protected TokenStreamComponents createComponents(String fieldName, Reader reader) {
    final StandardTokenizer src = new StandardTokenizer(reader);
    TokenStream tok = new StandardFilter(src);
    tok = new LowerCaseFilter(tok);
    tok = new StopFilter(tok, StandardAnalyzer.STOP_WORDS_SET);
    tok = new PorterStemFilter(tok);
    return new TokenStreamComponents(src, tok);
  }
}