public HeaderBlock(InputStream stream) throws IOException {
    // Grab the first 512 bytes
    // (For 4096 sized blocks, the remaining 3584 bytes are zero)
    // Then, process the contents
    this(readFirst512(stream));
    ...
}