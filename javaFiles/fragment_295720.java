public boolean AndSC(int x, int value, int y) {
    return value >= x && value <= y;
}

public boolean AndNonSC(int x, int value, int y) {
    return value >= x & value <= y;
}