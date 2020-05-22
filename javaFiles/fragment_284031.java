public static String eliminateDuplicates(String source) {
    StringBuilder result = new StringBuilder();
    for (int i = 0, sLength = source.length(); i < sLength; i++) {
        char readyToAdd = source.charAt(i);
        boolean add = true;

        for (int j = 0; j < result.length(); j++) {
            if (readyToAdd == result.charAt(j)) {
                add = false;
                break;
            }
        }

        if (add) result.append(readyToAdd);
    }

    return result.toString();
}