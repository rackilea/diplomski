public static boolean match(String host, String mask) {
    String[] sections = mask.split("\\*");
    String text = host;
    for (String section : sections) {
        int index = text.indexOf(section);
        if (index == -1) {
            return false;
        }
        text = text.substring(index + section.length());
    }
    return true;
}