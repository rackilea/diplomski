try {
    ... // code that can throw IOException or some user-defined ParserException
} catch(IOException | ParserException e) {
    e = new IOException(); // this is NOT acceptable -- e may reference a ParserException
    e.printStackTrace();
}