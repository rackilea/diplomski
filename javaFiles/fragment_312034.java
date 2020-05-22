int minLen = Math.min(a.length(), b.length());
for (int i = 0 ; i != minLen ; i++) {
    char chA = a.charAt(i);
    char chB = b.charAt(i);
    if (chA != chB) {
        ...
    }
}