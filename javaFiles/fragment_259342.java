public int getFreq(String word) {
    int val = word.charAt(0) - 64;
    if (word.length() > 1) {
        return c[val].getFreq(word.substring(1));
    } else if (c[val].flag == true && word.length() == 1) {
        return c[val].frequency;
    } else
        return -1;
}