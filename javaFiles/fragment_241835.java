public class AlphanumericAnalyzer extends Analyzer {

    @Override
    public TokenStream tokenStream(String fieldName, Reader reader) {

        return new TrimFilter(new PatternReplaceFilter(new LowerCaseFilter(new KeywordTokenizer(reader)), Pattern.compile("[^a-zA-Z0-9]"), "", true), true);
    }
}