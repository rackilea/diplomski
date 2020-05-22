final int charQuantity = 'z' - 'a';
int[] counter = new int[charQuantity];
while ( (ch = reader.read()) >= 0) {
    if (Character.isLetter(ch)) {
        counter[Character.toLowerCase(ch) - 'a']++;
    }
}