private static void appendEscaped( StringBuffer sBuffer, String str) {
    char [] strChars = str.toCharArray();
    for ( char c : strChars ) {
        if ( c >= ' ' && c <= '~' && c != '/') {
            // Character is ASCII, append as is
            sBuffer.append(c);
        } else {
            sBuffer.append(String.format("\\u%04x", (int)c));
        }
    }
}