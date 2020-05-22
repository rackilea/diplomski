private void consumeHeader() throws IOException {
        // Read the 10-byte header. We peek at the flags byte first so we know if we
        // need to CRC the entire header. Then we read the magic ID1ID2 sequence.
        // We can skip everything else in the first 10 bytes.
        // +---+---+---+---+---+---+---+---+---+---+
        // |ID1|ID2|CM |FLG|     MTIME     |XFL|OS | (more-->)
        // +---+---+---+---+---+---+---+---+---+---+
        source.require(10);
        ...
    }