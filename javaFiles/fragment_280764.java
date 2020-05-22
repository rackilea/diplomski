public String longest(char[] chars, List<String> strings) {
    char[] sorted = Arrays.copyOf(chars, chars.length);
    Arrays.sort(sorted);
    String result = null;
    for (String string : strings) {
        if (containsAll(sorted, string)
            && (result == null || string.length() > result.length())) {
            result = string;
        }
    }
    return result;
}
public boolean containsAll(char[] sorted, String string) {
    int length = string.length();
    for (int i = 0; i < length; ++i) {
        if (Arrays.binarySearch(sorted, string.charAt(i)) < 0) {
            return false;
        }
    }
    return true;
}