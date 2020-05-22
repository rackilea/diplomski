while (!s.isEmpty()) {
    char ch = s.charAt(0);
    if (Character.isLowerCase(ch))
        l += ch;
    else u += ch;
    s = s.substring(1);
}