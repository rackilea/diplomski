char[] chars = str.toCharArray();
for (int i = 0; i < chars.length - 1; i++) {
    if (chars[i] == '-' && Character.isDigit(chars[i + 1])) {
        chars[i] = '*';
    }
    // Similarly for the other two
}
String newString = new String(chars);