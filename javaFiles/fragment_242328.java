private static void printLongestTimesFiveSequence(int ... input) {
    Map<Integer, Integer> valueLengthMap = new HashMap<>();
    int longestLength = 0, longestValue = 0;
    for (int value : input) {

        // Find length of sequence ending in 'value'
        int length = 1;
        if (value % 5 == 0) {
            Integer prevLength = valueLengthMap.get(value / 5);
            if (prevLength != null)
                length += prevLength;
        }

        // If length is new longest sequence, remember it
        if (length > longestLength) {
            longestLength = length;
            longestValue = value;
        }

        // Remember length of sequence ending in 'value' if first time seen,
        // or if longer than previously seen (e.g. for 15, 3, 15)
        Integer currentLength = valueLengthMap.get(value);
        if (currentLength == null || currentLength < length)
            valueLengthMap.put(value, length);
    }

    // Build sequence ending in value of remembered longest sequence
    int[] sequence = new int[longestLength];
    for (int i = longestLength - 1, value = longestValue; i >= 0; i--, value /= 5)
        sequence[i] = value;

    // Print result
    System.out.println(longestLength + " " + Arrays.toString(sequence));
}