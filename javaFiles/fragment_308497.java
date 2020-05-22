public final static byte[] decode(String str) {
    // Check special case
    int sLen = str != null ? str.length() : 0;
    if (sLen == 0) {
        return new byte[0];
    }

    // Count illegal characters (including '\r', '\n') to know what size the returned array will be,
    // so we don't have to reallocate & copy it later.
    int sepCnt = 0; // Number of separator characters. (Actually illegal characters, but that's a bonus...)
    for (int i = 0; i < sLen; i++) {
        if (IA[str.charAt(i)] < 0) {
            sepCnt++;
        }
    }

    // Check so that legal chars (including '=') are evenly divideable by 4 as specified in RFC 2045.
    if (((sLen - sepCnt) % 4) != 0) {
        return null;
    }

    // Count '=' at end
    int pad = 0;
    for (int i = sLen; (i > 1) && (IA[str.charAt(--i)] <= 0);) {
        if (str.charAt(i) == '=') {
            pad++;
        }
    }

    int len = (((sLen - sepCnt) * 6) >> 3) - pad;

    byte[] dArr = new byte[len]; // Preallocate byte[] of exact length

    for (int s = 0, d = 0; d < len;) {
        // Assemble three bytes into an int from four "valid" characters.
        int i = 0;
        for (int j = 0; j < 4; j++) { // j only increased if a valid char was found.
            int c = IA[str.charAt(s++)];
            if (c >= 0) {
                i |= c << (18 - (j * 6));
            } else {
                j--;
            }
        }
        // Add the bytes
        dArr[d++] = (byte) (i >> 16);
        if (d < len) {
            dArr[d++] = (byte) (i >> 8);
            if (d < len) {
                dArr[d++] = (byte) i;
            }
        }
    }
    return dArr;
}