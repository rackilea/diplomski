public static String RePermute(final String text, final int[] table) {
    final String keys = text;

    char[] chararray = new char[table.length];

    for (int i = 0; i < keys.length() && i < table.length; i++) {
        chararray[table[i]-1] = keys.charAt(i);
    }

    return new String(chararray);
}