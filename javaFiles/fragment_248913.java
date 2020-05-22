public String everyNth(String s, int n) {
    if (s.length() >= n) {
        return s.charAt(n - 1) + everyNth(s.substring(n), n);
    } else {
        return "";
    }
}