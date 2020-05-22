public static List<String> splitByText(String text, String sep, int maxLength) {
    List<String> ret = new ArrayList<String>();
    int start = 0;
    while (start + maxLength < text.length()) {
        int index = text.lastIndexOf(sep, start + maxLength);
        if (index < start)
            throw new IllegalArgumentException("Unable to break into strings of " +
                    "no more than " + maxLength);
        ret.add(text.substring(start, index));
        start = index + sep.length();
    }
    ret.add(text.substring(start));
    return ret;
}