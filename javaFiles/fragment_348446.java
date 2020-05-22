try {
    thisCodeCanNeverThrowAnIOException();
}
catch (IOException e) {
    throw new AssertionError(e); // juuust in case!
}