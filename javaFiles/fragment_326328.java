byte[] response = nfc.transceive(new byte[] {
    (byte) 0xA2, // WRITE
    (byte) 40,   // page address
    pack[0], pack[1],   // bytes 0-1 are PACK value
    (byte) 0, (byte) 0  // other bytes are RFU and must be written as 0
});