public static String addCommas(int num) {
    StringBuilder s = new StringBuilder(Integer.toString(num));
    for(int i = s.length() - 3; i > 0; i -= 3) {
        s.insert(i, ',');
    }
    return s.toString();
}