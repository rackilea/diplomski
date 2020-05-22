try {
    something();
} catch (FileSystemException e) {
    // fs level error
} catch (IOException e) {
    // I/O error
}