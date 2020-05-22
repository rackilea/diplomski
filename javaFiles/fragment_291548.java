public static void shuffle(Random r, Vector<?> v) {
    privateShuffle(r, v);
}

private static <T> void privateShuffle(Random r, Vector<T> v) {
    int sz = v.size();
    for (int pass = 0; pass < 4; pass++) {
        for (int i = 0; i < sz; i++) {
            int j=nextInt(r,sz);
            T ii = v.elementAt(i);
            v.setElementAt(v.elementAt(j), i);
            v.setElementAt(ii, j);
        }
    }
}