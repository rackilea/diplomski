static int firstDifference(String s1, String s2, int L) {
    for (int i = 0; i < L; i++) {
        if (s1.charAt(i) != s2.charAt(i)) {
            return i;
        }
    }
    return L;
}
static boolean oneEdit(String s1, String s2) {
    if (s1.length() > s2.length()) {
        return oneEdit(s2, s1);
    }
    final int L = s1.length();
    final int index = firstDifference(s1, s2, L);
    if (s1.length() == s2.length() && index != L) {
        return s1.substring(index+1).equals(s2.substring(index+1));
    } else if (s2.length() == L + 1) {
        return s1.substring(index).equals(s2.substring(index+1));
    } else {
        return false;
    }
}