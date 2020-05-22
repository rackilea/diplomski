static String whichArrayContains(String value, String[]... arrays) {
    for (String[] array : arrays) {
        if (Arrays.asList(array).contains(value)) {
            return array[0];
        }
    }
    return null;
}