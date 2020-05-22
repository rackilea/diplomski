Comparator<String> comparator = (a,b) -> {
    int r = Integer.compare(a.length(), b.length());
    if (r != 0) {
        return r;
    }
    return a.compareTo(b);
};