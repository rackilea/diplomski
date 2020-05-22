void write(int[] array) {
    writeInt(array.length);
    int ni;
    for (int i = 0; i < array.length; i = ni) {
        ni = i + 32;
        int zeroesMap = 0;
        for (j = i + 31; j >= i; j--) {
            zeroesMap <<= 1;
            if (array[j] == 0) {
                zeroesMap |= 1;
            }
        }
        writeInt(zeroesMap);
        for (j = i; j < ni; j++)
            if (array[j] != 0) {
                writeInt(array[j]);
            }
        }
    }
}

int[] read() {
    int[] array = new int[readInt()];
    int ni;
    for (int i = 0; i < array.length; i = ni) {
        ni = i + 32;
        zeroesMap = readInt();
        for (j = i; j < ni; j++) {
            if (zeroesMap & 1 == 1) {
                // nothing to do (array[i] was initialized to 0)
            } else {
                array[j] = readInt();
            }
            zeroesMap >>= 1;
        }
    }
    return array;
}