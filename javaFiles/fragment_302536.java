public static int stringToInt(String number) {
    int res = 0;
    for (int i = 0; i < number.length(); i++) {
        res = res * 10 + number.charAt(i) - '0';
    }
    return res;
}