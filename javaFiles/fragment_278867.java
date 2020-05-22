private int diffpos(byte[] a, byte[] b, int typeLenght){
    if (a.length == b.length) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return i / typeLenght;
            }
        }
    }
    return 0;
}