public static String smallestLetter(String str) {
    char ret = str.charAt(0);
    for (int i = 1; i < str.length(); ++i)
        if (str.charAt(i) < ret)
            ret = str.charAt(i);
    return String.valueOf(ret);
}