byte[] response = nfc.transceive(new byte[] {
    (byte) 0x1B, // PWD_AUTH
    pass[0], pass[1], pass[2], pass[3]
});
if ((response != null) && (response.length >= 2)) {
   byte[] pack = Arrays.copyOf(response, 2);
   // TODO: verify PACK to confirm that tag is authentic (not really,
   // but that whole PWD_AUTH/PACK authentication mechanism was not
   // really meant to bring much security, I hope; same with the
   // NTAG signature btw.)
}