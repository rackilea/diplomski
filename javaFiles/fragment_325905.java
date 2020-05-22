static int getUtf8ByteCount(int codePoint) throws CharacterCodingException {
    return StandardCharsets.UTF_8
            .newEncoder()
            .encode(CharBuffer.wrap(new String(new int[] { codePoint }, 0, 1)
                    .toCharArray())).array().length;
}