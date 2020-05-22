private StreamTokenizer() {
    wordChars('a', 'z');
    wordChars('A', 'Z');
    wordChars(128 + 32, 255);
    whitespaceChars(0, ' ');
    commentChar('/');
    quoteChar('"');
    quoteChar('\'');
    parseNumbers();
}