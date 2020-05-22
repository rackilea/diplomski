static String reverseWordInAString(String str) {
    char[] array = str.toCharArray();
    int length = array.length;
    reverseString(array, 0, length - 1);
    int i = 0, start = 0;
    while (i < length) {
        if (array[i] == ' ') {
            reverseString(array, start, i - 1);
            start = i + 1;
        }
        i++;
    }

    if (start < i) {
        reverseString(array, start, i - 1);
    }
    return new String(array);
}