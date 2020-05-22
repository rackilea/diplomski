private int hash;

@Override public int hashCode() {
    int h = hash;
    if (h == 0) {
        int len = name.length();
        h = 1;
        for (int i = 0; i < len; i++) {
            h = 47*h + name.charAt(i);
        }
        hash = h;
    }
    return h;
}