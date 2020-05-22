public boolean addIfValid(int n) {
    for (int i = 0; i < 16; i++) {
        if (n == buildIndex[i]) return false;
    }
    return true;
}