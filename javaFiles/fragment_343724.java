private static Number parseFromString(String str) throws NumberFormatException {
    if (str.matches("\\d+")) {
        return Integer.valueOf(str);
    } else if (str.matches("[-+]?[0-9]*\\.?[0-9]+")) {
        return Double.valueOf(str);
    }
    throw new NumberFormatException("Number not correct");
}