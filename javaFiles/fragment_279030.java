private void initialize() {
    char magic3, magic4;
    magic3 = bsGetUChar();
    magic4 = bsGetUChar();
    if (magic3 != 'h' || magic4 < '1' || magic4 > '9') {
        bsFinishedWithStream();
        streamEnd = true;
        return;
    }
    setDecompressStructureSizes(magic4 - '0');
    computedCombinedCRC = 0;
}