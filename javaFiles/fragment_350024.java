for (int i = 0; i < chars.length - 1; i++) {
    if (Character.isDigit(chars[i + 1]) &&
        (chars[i] == '-' || chars[i] == 'e' || chars[i] == '.')) {
        chars[i] = '*';
    }
}