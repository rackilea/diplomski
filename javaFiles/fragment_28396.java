private int getIntFromHexNibble(char value, int offset) {
    int pos = getAlphabet().indexOf(value);
    if (pos == -1) {// nothing found}
        pos -= offset;

        while (pos < 0) {
            pos += 16;
        }
        return pos % 16;
    }