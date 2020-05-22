for (int i = 0; i < N + 2; i++) {
    StringBuilder keySubstring = new StringBuilder();
    for (int j = 0; j < 8; j++) {
        int index = (i * 8 + j) % key.length();
        keySubstring.append(key.charAt(index));
    }
    long keyChunk = Long.parseLong(keySubstring.toString(), 16);
    P[i] ^= keyChunk;
}