static String starOutFirst(String s) {
    final int K = s.indexOf('.');
    return "*" + s.substring(K);
}
static String starOutButLastTwo(String s) {
    final int K = s.lastIndexOf('.', s.lastIndexOf('.') - 1);
    return "*" + s.substring(K);
}