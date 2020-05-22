class CharReader {
    private Stack marks;
    private RandomAccessFile reader;

    CharReader(File file) {
        this.marks = new Stack();
        this.reader = new RandomAccessFile(file, 'r');
    }

    void mark() {
        long mark = reader.getFilePointer();
        marks.push(mark);
    }

    void reset() {
        if (marks.size() <= 0)
            return

        long mark = marks.pop();
        reader.seek(mark);
    }

    char peek() {
        mark();
        char nextChar = next();
        reset();
        return nextChar;
    }


    char next() {
        int nextChar;
        if ((nextChar = nextInt()) >= 0) {
            return (char) nextChar;
        }
        throw new IllegalStateException("Reader empty");
    }

    private int nextInt() {
        return reader.read();
    }
}