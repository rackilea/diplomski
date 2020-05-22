StreamTokenizer tokenizer = new StreamTokenizer(fileInputStream);
tokenizer.wordChars('_', '_');
tokenizer.nextToken(); 
while ("define".equals(tokenizer.sval)) {
  tokenizer.nextToken();
  String recordName = tokenizer.sval;
  if (tokenizer.nextToken() != '{') {
    throw new RuntimeException("'{' expected");
  }
  while (tokenizer.nextToken() != '}') {
    String key = tokenizer.sval;
    tokenizer.nextToken();
    String value = tokenizer.sval;
    tokenizer.eolIsSignificant(true);
    while (tokenizer.nextToken() != StreamTokenizer.TT_EOL &&
           tokenizer.nextToken() != StreamTokenizer.TT_EOF) {
      value += " " + tokenizer.sval();  // If this is common, use StringBuilder
    }
    tokenizer.eolIsSignificant(false);
  }
}