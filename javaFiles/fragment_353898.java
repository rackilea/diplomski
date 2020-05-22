public static String plusOut(String str, String word)
{
    String ret = "";
    for (int i = 0; i < str.length(); ++i) {
        int endIndex = i + word.length();
        if (endIndex < str.length() + 1
                && str.substring(i, i + word.length()).equals(word)) {
            ret += word;
            i = i + word.length() - 1;
        } else
            ret += "+";
    }
    return ret;
}