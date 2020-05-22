interface LineReader {
    String readLine() throws IOException;
}

class BufferedLineReader extends BufferedReader implements LineReader {
   // ...
}

class SpecialLineReader implements LineReader {
    @Override
    public String readLine() throws IOException {
        // ...
    }
}