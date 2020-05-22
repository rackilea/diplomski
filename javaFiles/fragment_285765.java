public static String convert(String in) {

    // put in the string the accented characters to be converted
    final String accented = "ÁÉÍÓÚ";
    char[] outChars = in.toCharArray();

    for (int i = 0, n = outChars.length; i < n; i++)
        if (accented.indexOf(outChars[i]) != -1)
            outChars[i] = Character.toLowerCase(outChars[i]);

    return new String(outChars);

}