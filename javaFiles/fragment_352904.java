// actual business logic
public String hexEncoder(String content) {
    return Hex.encodeHexString(content.getBytes());
}

// input and assertion
@Test
public void hexEncoder() throws DecoderException {
    String guid = "YxRfXk827kPgkmMUX15PNg==";

    String hexString = hexEncoder(guid);
    String hexDecoded = new String(Hex.decodeHex(hexString));

    // no need to decode Base64 but might be useful for `printLn` or debugging
    String s = new String(Base64.decodeBase64(guid));
    String s1 = new String(Base64.decodeBase64(hexDecoded));

    assertEquals(s, s1);
}