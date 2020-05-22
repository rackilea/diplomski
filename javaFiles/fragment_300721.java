Integer length = null;
if (big != null) {
    Small small = big.getSmall();
    if (small != null) {
        Tiny tiny = small.getTiny();
        if (tiny != null) {
            length = tiny.getTinyLength();
        }
    }
}
if (length != null) {
    return length;
} else {
    // Throw exception, return null, or do whatever
}