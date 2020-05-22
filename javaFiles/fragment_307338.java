int sentenceIdx = 1;
List<CoreMap> sentences = new ArrayList<CoreMap>();
for (parsedSentence : parsedSentences) {
    CoreMap sentence = new CoreLabel();
    List<CoreLabel> tokens = new ArrayList<>();
    for(int tokenCount = 0; tokenCount < parsedSentence.size(); tokenCount++) {

        ArrayList<String> parsedLine = parsedSentence.get(tokenCount);
        String word = parsedLine.get(1);
        String lemma = parsedLine.get(2);
        String posTag = parsedLine.get(3);
        String namedEntity = parsedLine.get(4); 
        String partOfParseTree = parsedLine.get(6);

        CoreLabel token = new CoreLabel();
        token.setWord(word);
        token.setLemma(lemma);
        token.setTag(posTag);
        token.setNER(namedEntity);
        token.setIndex(tokenCount + 1);
        tokens.add(token);
    }

    // set tokens annotations and id of sentence 
    sentence.set(TokensAnnotation.class, tokens);
    sentence.set(SentenceIndexAnnotation.class, sentenceIdx++);

    // set parse tree annotations to annotation
    Tree stanfordParseTree = Tree.valueOf(inputParseTree);
    sentence.set(TreeAnnotation.class, stanfordParseTree);

    // add sentence to list of sentences
    sentences.add(sentence);
}