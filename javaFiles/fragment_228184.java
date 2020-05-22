public int compare(Integer a, Integer b) {
    if (base.get(a) >= base.get(b)) {
        return -1;
    } else {
        return 1;
    } // returning 0 would merge keys
}