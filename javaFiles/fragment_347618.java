public randomConstructor(Reader r) {
    if (r instanceof BufferedReader) {
        this.bufferedreader = (BufferedReader) r;
    } else {
        this.bufferedreader = new BufferedReader(r);
    }
}