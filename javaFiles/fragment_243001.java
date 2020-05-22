public static String replaceChars(final String str, final String sourceChars, final String replaceChars) {

    int ix;
    final StringBuilder sb = new StringBuilder(str);
    for (int i = 0 ; i < sb.length() ; i++) {
        if ((ix = sourceChars.indexOf(sb.charAt(i))) != -1) {
            sb.replace(i, i + 1, replaceChars.substring(ix, ix + 1));
        }
    }

    return sb.toString();
}