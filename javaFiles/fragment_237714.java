char[] chars = in.toCharArray();
for (int i = 0; i < chars.length; i++) {
    if (chars[i] == guess) {
        count++;
    }
}