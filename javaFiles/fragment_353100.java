public Integer myWrappedMethod(String s) {
    try {
        return myMethod(s);
    }
    catch(IOException e) {
        throw new UncheckedIOException(e);
    }
}