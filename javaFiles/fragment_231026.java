public static String encode(String header) {
    char[] code = new char[32];
    for(int i = 0; i < header.length(); i++) {
        code[i % code.length] = (char)((int)code[i % code.length] ^ (int)header.charAt(i));
    }
    return new String(code);
}