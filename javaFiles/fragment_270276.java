public class IgnoreStopWordsAnalyzer extends StopwordAnalyzerBase {

    public IgnoreStopWordsAnalyzer() {
        super(Version.LUCENE_36, null);
    }

    @Override
    protected ReusableAnalyzerBase.TokenStreamComponents createComponents(final String fieldName, final Reader reader) {
        final StandardTokenizer src = new StandardTokenizer(Version.LUCENE_36, reader);
        TokenStream tok = new StandardFilter(Version.LUCENE_36, src);
        tok = new LowerCaseFilter(Version.LUCENE_36, tok);
        tok = new StopFilter(Version.LUCENE_36, tok, this.stopwords);
        return new ReusableAnalyzerBase.TokenStreamComponents(src, tok);
    }
}