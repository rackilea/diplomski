public static String format(String inputUnformatted, int groupSize, String separator) {
    StringBuilder result = new StringBuilder(inputUnformatted);

    int i = groupSize;
    while (i < inputUnformatted.length()) {
        result.insert(inputUnformatted.length() - i, separator);
        i += groupSize;
    }

    return result.toString();
}