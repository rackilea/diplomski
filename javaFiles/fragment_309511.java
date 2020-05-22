public String toUpperCase() {
    char[] duplicate = new char[letters.length];
    String upperCase = "";
    int a = 0;
    int b = 0;
    for (int i = 0; i < letters.length; i++) {
        a = letters[i];
        if (a >= 97 && a <= 122) {
            b = a - 32;
            duplicate[i] = (char) b;
        }
        upperCase = upperCase + duplicate[i];
    }
    return upperCase;
}