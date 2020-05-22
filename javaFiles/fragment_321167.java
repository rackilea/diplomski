public static void main(String[] args) throws IOException {
    StringReader inputText = new StringReader("This is a TEST string");
    Map<String, String> param = new HashMap<>();
    param.put("luceneMatchVersion", "LUCENE_44");

    TokenizerFactory stdTokenFact = new StandardTokenizerFactory(param);
    Tokenizer tokenizer = stdTokenFact.create(inputText);

    param.put("luceneMatchVersion", "LUCENE_44");
    LowerCaseFilterFactory lowerCaseFactory = new LowerCaseFilterFactory(param);
    TokenStream tokenStream = lowerCaseFactory.create(tokenizer);

    CharTermAttribute termAttrib = (CharTermAttribute) tokenStream.getAttribute(CharTermAttribute.class);

    tokenStream.reset();

    while (tokenStream.incrementToken()) {
        System.out.println("CharTermAttribute Length = " + termAttrib.length());

        System.out.println(termAttrib.toString());
    }

    tokenStream.end();
    tokenStream.close();
}