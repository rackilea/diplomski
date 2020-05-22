private String wrapText(String in) {
    String r;
    if(in.contains(" ")) {
        int middle = in.length() / 2;
        int before = getSpaceBeforeIndex(in, middle);
        int after = getSpaceAfterIndex(in, middle);

        int rightOne;

        if(before == -1) {
            rightOne = after;
        } else if(after == -1) {
            rightOne = before;
        } else {
            rightOne = (middle - before) < (after - middle)? before : after;
        }

        r = in.substring(0, rightOne) + "\n" + in.substring(rightOne);
    } else {
        r = in;
    }

    return r;
}

private static int getSpaceBeforeIndex(String in, int index) {
    String cut = in.substring(0, index);
    int firstSpace = cut.lastIndexOf(" ");
    return firstSpace;
}

private static int getSpaceAfterIndex(String in, int index) {
    int nextSpace = in.indexOf(" ", index);
    return nextSpace;
}