@Override
protected Reader initReader(String fieldName, Reader reader) {
    return mStripHTML ? new HTMLStripCharFilter(reader) : reader;
}

@Override
protected TokenStreamComponents createComponents(String fieldName) 
{
    StandardTokenizer source = new StandardTokenizer();
    source.setMaxTokenLength(maxTokenLength);
    TokenStream result = new StandardFilter(source);
    result = new LowerCaseFilter(result);
    return new TokenStreamComponents(source, result);
}