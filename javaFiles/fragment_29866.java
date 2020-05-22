public boolean allEqual(int... values) {
    for (int i = 0; i < values.length-1; i++) {
        if (values[i] != values[i+1]) {
            return false;
        }
    }
    return true;
}