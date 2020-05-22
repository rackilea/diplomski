public static boolean isDoubled(String s) {
    if (s.length() % 2 == 0)
        return false;
    if (s.length() == 1)
        return true;

    int mid = s.length() / 2;
    return s.substring(0, mid).equals(s.substring(mid + 1));
}