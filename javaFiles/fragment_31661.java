Files.readLines(myFile, Charsets.UTF_8, new LineProcessor<T>() {

    @Override
    public boolean processLine(final String line) throws IOException {
        //process line
    }

    @Override
    public T getResult() {
        //return result
    }
});