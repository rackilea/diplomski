for (int i = 0, j = 0; i < sb.length(); i++) {
    char ch = sb.charAt(i);
    if (Character.isDigit(ch)) {
        if (counts[ch - '0']++ == 0)
            order[j++] = ch; // First occurrence of ch
    }
}