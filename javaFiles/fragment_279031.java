private void initialize() {
    char magic1, magic2; 
    char magic3, magic4; 
    magic1 = bsGetUChar(); 
    magic2 = bsGetUChar(); 
    magic3 = bsGetUChar(); 
    magic4 = bsGetUChar(); 
    if (magic1 != 'B' || magic2 != 'Z' | magic3 != 'h' || magic4 < '1' || magic4 > '9') {   
        bsFinishedWithStream();
        streamEnd = true;
        return;
    }
    setDecompressStructureSizes(magic4 - '0');
    computedCombinedCRC = 0;
}