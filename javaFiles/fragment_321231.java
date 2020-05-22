String wordstring=config.get("mapper.word");
while (itr.hasMoreTokens()) {
    String token = itr.nextToken();
    if(wordstring.equals(token)) {
        word.set(token);
        context.write(word, one);
   }