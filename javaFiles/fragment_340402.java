private static int countChar(String in, char v) {
    int count = 0;
    if (in != null) {
        for (char ch : in.toCharArray()) {
            if (ch == v) {
                count++;
            }
        }
    }
    return count;
}