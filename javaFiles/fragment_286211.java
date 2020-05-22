public int method(int i) {
    if (i < 7) {
        i++;
        return method(i);
    } else {
        return i;
    }
}