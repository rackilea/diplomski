byte[] response = nfc.transceive(new byte[] {
    (byte) 0x30, // READ
    (byte) 37    // page address
});
if ((response != null) && (response.length >= 16)) {  // read always returns 4 pages
    boolean prot = false;  // false = PWD_AUTH for write only, true = PWD_AUTH for read and write
    int auth0 = 0; // first page to be protected, set to a value between 0 and 37 for NTAG212
    response = nfc.transceive(new byte[] {
        (byte) 0xA2, // WRITE
        (byte) 37,   // page address
        response[0], // keep old value for byte 0
        response[1], // keep old value for byte 1
        response[2], // keep old value for byte 2
        (byte) (auth0 & 0x0ff)
    });
}