public int comlen(CharSequence s, CharSequence m) {
    int end = s.length() > m.length() ? m.length() : s.length();
    int i = 0;
    while (i < end && s.charAt(i) == m.charAt(i)) {
        i++;
    }
    return i;
}