public boolean hasColumn(Marble m, int i, int j, int wincount) {
    if (wincount == WINLENGTH)
        return true;
    if (i == DIM)
        return false;
    if (j == DIM)
        return hasColumn(m, i + 1, 0, 0);
    return hasColumn(m, i, j + 1, getField(j, i).equals(m) ? wincount + 1 : 0);
}