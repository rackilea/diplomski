private String trim(String str) {
    int beginIndex = 0;
    int endIndex = str.length() - 1;

    while (true) {
        if (str.charAt(beginIndex) == ' ') {
            beginIndex++;
        } else if (str.charAt(endIndex) == ' ') {
            endIndex--;
        } else {
            break;
        }
    }

    return str.substring(beginIndex, endIndex);
}