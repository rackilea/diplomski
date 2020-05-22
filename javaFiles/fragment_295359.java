public int compare(String a, String b) {
    if (base.get(a) > base.get(b)) {
        return -1;
    } else if (base.get(a) < base.get(b)) {
        return 1;
    } else {
        int stringCompare = a.compareToIgnoreCase(b);
        return stringCompare == 0 ? 1 : stringCompare; // returning 0 would merge keys
    }
}