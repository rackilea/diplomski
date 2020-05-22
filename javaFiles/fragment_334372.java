public static List<String> splitString(String inputString, int... lengths) {

    List<String> substrings = new ArrayList<String>();

    int start = 0;
    int end = 0;

    for(int length : lengths) {

        start = end;
        end = start + length;

        String substring  = inputString.substring(start, end);
        substrings.add(substring);
    }

    return substrings;
}