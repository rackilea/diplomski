public static int duplicatesCount(String text) {
    int cnt = 0;
    while (text.length() > 1) {
        char firstLetter = text.charAt(0);
        if (text.lastIndexOf(firstLetter) > 0) {
            cnt++;
            text = text.replaceAll(("" + firstLetter), "");
        } else {
            text = text.substring(1, text.length());
        }
    }

    return cnt;
}