private Path saveAsFile(InputStream stream) throws IOException {
    // Maybe you should advance the stream to skip the "data/image stuff"...
   //stream.skip(theActualNumberOfBytesToSkip);
    try (Base64InputStream decoded = new Base64InputStream(stream); FileOutputStream file = /*whatever*/) {
        IOUtils.copy(decoded, file);
    }
}