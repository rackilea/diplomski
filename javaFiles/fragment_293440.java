public boolean booleanFraction(boolean a, boolean b, boolean c, boolean d) {
    int ia = a ? 1 : 0;
    int ib = b ? 1 : 0;
    int ic = c ? 1 : 0;
    int id = d ? 1 : 0;
    return ia + ib + ic + id == 3;
}