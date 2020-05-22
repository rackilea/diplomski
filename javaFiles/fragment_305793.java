public static int countX(String str) {
    int count = 0;

    if (str.length() > 0) {
        if (str.substring(0, 1).equals("x")) {
            ++count;
        }

        str = str.substring(1, str.length());
        count += countX(str);

    }

    return count;
}