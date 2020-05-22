public static String e(String toEncrypt, int encKey, boolean addEncKey) {       
    encKey %= ALPHABET.length;
    toEncrypt = toEncrypt.toLowerCase();
    char[] TEChar = toEncrypt.toCharArray();
    for (int i = 0; i < toEncrypt.length(); i++) {
        for (int j = 0; j < ALPHABET.length; j++) {
            if (TEChar[i] == '`') {
                TEChar[i] = '_';
            } else if (TEChar[i] == ALPHABET[j]) {
                TEChar[i] = ALPHABET[(j + encKey + ALPHABET.length)
                        % ALPHABET.length];
                break;
            }
        }
    }
    if (addEncKey) {
        toEncrypt = String.valueOf(TEChar) + "`" + encKey;
    } else {
        toEncrypt = String.valueOf(TEChar);
    }
    return toEncrypt;
}