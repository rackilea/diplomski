public int getThing(final boolean a, final boolean b) {
    if (a && b) {
        return 3;
    }
    if (a) {
        return 1;     
    }
    if (b) {
        return 2;
    }
    return 0;
}