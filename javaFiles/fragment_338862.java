Comparator<String> comparator = new Comparator<String>() {
    public int compare(String a, String b) {
        int r = Integer.compare(a.length(), b.length());
        if (r != 0) {
            return r;
        }
        return a.compareTo(b);
    }
};