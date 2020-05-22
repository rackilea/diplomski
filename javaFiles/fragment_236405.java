int[] indexToElement(int index, int base) {
    String string = Integer.toString(index, base);
    int[] element = new int[string.length()];

    for (int i = 0; i < string.length(); ++i) {
        element[i] = Character.digit(string.charAt(string.length() - i - 1), base);
    }

    return element;
}