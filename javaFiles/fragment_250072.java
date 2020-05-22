public final class StopFilter extends FilteringTokenFilter {

    private final CharArraySet stopWords;
    private final CharTermAttribute termAtt = addAttribute(CharTermAttribute.class);

    public StopFilter(Version matchVersion, TokenStream in, CharArraySet stopWords) {
        super(matchVersion, in);
        this.stopWords = stopWords;
    }

    @Override
    protected boolean accept() {
        return !stopWords.contains(termAtt.buffer(), 0, termAtt.length());
    }
}