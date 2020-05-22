if (str.length() == 1) {
    char ch = charAt(0);
    // code here
} else if (str.endsWith("i")) {
    int num = Integer.parseInt(str.substring(0, str.length() - 1));
    // code here
} else {
    throw new IllegalArgumentException("Bad input: " + str);
}