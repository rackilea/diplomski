try {
    ... // code that can throw IOException or some user-defined ParserException
} catch(IOException) {
    e = new IOException();  // this is acceptable (although there is no point in doing it)
    e.printStackTrace();
}