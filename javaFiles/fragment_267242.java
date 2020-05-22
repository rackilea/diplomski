public static String seeColor (String color) {
    String[] allow = {"red", "blue"};
    for (String s: allow)
        if (color.startsWith(s))
            return s;
    return "";
}