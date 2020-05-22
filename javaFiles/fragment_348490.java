class MyBufferedReader extends BufferedReader {

    MyBufferedReader(Reader r) {
        super(r);
    }

    @Override
    String readLine() {
        String line = super.readLine();
        // perform replacement here
        return line;
    }

}