for (int i = 0; i < str.length(); i++) {
    char ch = str.charAt(i);
    if (ch != ' ') {
        ch = (char)((ch - 'A' + n) % 26 + 'A');
    }

    nstr += ch;
}