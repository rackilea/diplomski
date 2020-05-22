boolean differByOne(String w1, String w2) {
    int count = 0;
    for (int i = 0 ; i != 4 ; i++) {
        if (w1.charAt(i) != w2.charAt(i)) count++;
        if (count > 1) return false;
    }
    return count == 1;
}