Reader reader = new StringReader("This is a test string");
NGramTokenizer gramTokenizer = new NGramTokenizer(reader, 1, 3);
CharTermAttribute charTermAttribute = gramTokenizer.addAttribute(CharTermAttribute.class);
gramTokenizer.reset();

while (gramTokenizer.incrementToken()) {
    String token = charTermAttribute.toString();
    //Do something
}
gramTokenizer.end();
gramTokenizer.close();