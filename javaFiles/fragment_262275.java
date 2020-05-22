// open input
try (Scanner scanInput = new Scanner(new FileReader(fileEntry))) {
    // ... use the input in this block ...

    // the input is automatically closed when the try-with-resources block
    // is exited, even if an exception is thrown.
}
fileEntry.delete();