public static String[] removeFromArray(String[] inputArray, String removeString) {
    int removeStringOccurences = 0;
    for (String currString : inputArray) {
        if (currString.equals(removeString)) {
            removeStringOccurences++;
        }
    }
    String[] result = new String[inputArray.length - removeStringOccurences];
    int index = 0;
    for (String currString : inputArray) {
        if (!currString.equals(removeString)) {
            result[index] = currString;
            index++;
        }
    }
    return result;
}