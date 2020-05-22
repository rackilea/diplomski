/** replaces any invalid character in Latin1 by the character rep */
public static String latin1(String str, char rep) {
    CharsetEncoder cs = StandardCharsets.ISO_8859_1.newEncoder()
            .onMalformedInput(CodingErrorAction.REPLACE)
            .onUnmappableCharacter(CodingErrorAction.REPLACE)
            .replaceWith(new byte[] { (byte) rep });
    try {
        ByteBuffer b = cs.encode(CharBuffer.wrap(str));
        return new String(b.array(), StandardCharsets.ISO_8859_1);
    } catch (CharacterCodingException e) {
        throw new RuntimeException(e); // should not happen
    }
}