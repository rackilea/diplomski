public String everyNth(String str, int n) {
    if (n < 1) {
        throw new IllegalArgumentException("n must be greater than 0");
    }
    StringBuilder result = new StringBuilder();
    // The index of the previous match
    int previous = 0;
    for (int i = n-1; i < str.length(); i += n) {
        // Add substring from previous match to the current
        result.append(str, previous, i);
        // Set the new value of previous
        previous = i + 1;
    }
    // Add the remaining sub string
    result.append(str, previous, str.length());
    return result.toString();
}