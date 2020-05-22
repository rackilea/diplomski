Reader reader = new StringReader("This is a test string");
TokenStream tokenizer = new StandardTokenizer(Version.LUCENE_36, reader);
tokenizer = new ShingleFilter(tokenizer, 1, 3);
CharTermAttribute charTermAttribute = tokenizer.addAttribute(CharTermAttribute.class);

while (tokenizer.incrementToken()) {
    String token = charTermAttribute.toString();
    //Do something
}