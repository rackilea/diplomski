private int getLength(String str) {
    int length = 0;

    while (true) {
        try {
            str.charAt(length++);
        } catch (StringIndexOutOfBoundsException e) {
            break;
        }
    }
    return --length;
}