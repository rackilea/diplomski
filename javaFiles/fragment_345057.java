public TestArray(int i) {
    a = new Word[i];
    for(Word w:a) {
        w = new Word(0);
    }
}