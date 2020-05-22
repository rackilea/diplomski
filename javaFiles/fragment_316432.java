void write(int[] array) {
    BitSet zeroes = new BitSet();
    for (int i = 0; i < array.length; i++)
        zeroes.set(i, array[i] == 0);
    write(zeroes); // one bit per index
    for (int i = 0; i < array.length; i++)
        if (array[i] != 0)
            write(array[y]);
}

int[] read() {
    BitSet zeroes = readBitSet();
    array = new int[zeroes.length];
    for (int i = 0; i < zeroes.length; i++) {
        if (zeroes.get(i)) {
            // nothing to do (array[i] was initialized to 0)
        } else {
            array[i] = readInt();
        }
    }
}