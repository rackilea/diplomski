String convertToString(String[] numberArray) {
    byte[] utf8Bytes = new byte[numberArray.length];
    for (int i = 0; i < numberArray.length; i++) {
        utf8Bytes[i] = (byte) Integer.parseInt(numberArray[i]);
    }
    return new String(utf8Bytes, StandardCharsets.UTF_8);
}