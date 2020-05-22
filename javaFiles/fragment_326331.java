byte[] data = { (byte)..., (byte)..., (byte)..., (byte)... };
byte[] response = nfc.transceive(new byte[] {
    (byte) 0xA2,                  // WRITE
    (byte) (pageAddress & 0x0ff), // page address
    data[0], data[1], data[2], data[3]
});