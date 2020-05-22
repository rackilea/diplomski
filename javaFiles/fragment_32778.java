void setBit(int[] array, int index, boolean value) {
    int x = index / 32;
    int y = index % 32;
    int mask = 1 << y;
    if (value) {
        array[x] |= mask;
    }
    else {
        array[x] &= (0xFFFFFFFF ^ mask);
    }
}

boolean getBit(int[] array, int index) {
    int x = index / 32;
    int y = index % 32;
    int mask = 1 << y;
    return (array[x] & mask) != 0;
}