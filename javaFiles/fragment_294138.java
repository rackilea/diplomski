Iterator<String> i = words.iterator();
while (i.hasNext()) {
    String category = classifier.classify(i.next());
    if(classifier.needPreviousWord()){
        i.previous();
    }
    if(classifier.needNextWord()){
        i.next();
    }
}