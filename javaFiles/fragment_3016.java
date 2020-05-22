public int hashCode() {
    int res = 0;
    for(Object r : g.getcontents()) {
        res = 31 * res + r.hashCode();
    }
    return res;
}