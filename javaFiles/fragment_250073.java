public final class KeepOnlyFilter extends FilteringTokenFilter {

    private final CharArraySet keepWords;
    private final CharTermAttribute termAtt = addAttribute(CharTermAttribute.class);

    public KeepOnlyFilter(Version matchVersion, TokenStream in, CharArraySet keepWords) {
        super(matchVersion, in);
        this.keepWords = keepWords;
    }

    @Override
    protected boolean accept() {
        return keepWords.contains(termAtt.buffer(), 0, termAtt.length());
    }
}