try {
    Files.size(...);
} catch (FileSystemException e) {
    // deal with fs level error
} catch (IOException e) {
    // deal with I/O level error
}