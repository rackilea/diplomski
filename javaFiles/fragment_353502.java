private boolean byteArrayCheck3b(final byte[] array) {
    int hits = 0;
    for (byte b : array) {
        if (b != 0) {
            hits++;
        }
    }
    return (hits == 0);
}