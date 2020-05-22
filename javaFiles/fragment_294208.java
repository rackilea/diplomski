public static int countWords(char[] array) {
    if (array == null)
        throw new IllegalArgumentException("The received array is null");

    char[] array_new = trimLeadingSpaces(array);

    if (array_new.length == 0)
        return 0;

    int nextSpacePosition = idxFirstSpace(array_new, 0);
    int count = 1;

    if (nextSpacePosition > 0 && nextSpacePosition < array_new.length)
        count += countWords(Arrays.copyOfRange(array_new, nextSpacePosition, array_new.length));

    return count;
}