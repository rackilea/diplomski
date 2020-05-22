public static int arrayIndexOf(byte[] haystack, int offset, int length, byte[] needle) {
    for (int i=offset; i<offset+length-nedle.length(); i++) {
        boolean match = false;
        for (int j=0; j<needle.length(); j++) {
            match = haystack[i + j] == needle[j];
            if (!match)
                break;
        }
        if (match)
            return i;
    }
    return -1;
}