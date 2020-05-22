private boolean areArrayEqual(ArrayList<int[]> a, ArrayList<int[]> b) {
    if (a == null) return false;
    if (b == null) return false;
    if (a.size() != b.size()) return false;
    for (int i = 0; i < a.size(); i++) {
        int x[] = a.get(i);
        int y[] = b.get(i);
        if (x.length != y.length) return false;
        for (int j = 0; j < x.length; j++) {
            if (x[j] != y[j]) return false;
        }
    }
    return true;
}