public int compare(String a, String b) {
    int cmp = -map.get(a).compareTo(map.get(b));
    if (cmp == 0)
        cmp = a.compareTo(b);
    return cmp;
}