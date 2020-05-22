Reader r = new StringReader(Salad);
read(r);
...
private static void read(Reader r) throws IOException {
    int readChar;
    while ((readChar = r.read()) != -1) {
        char c = (char) readChar;
        if (c == ' '){
            //if character is a space, do something
        }
    }
}