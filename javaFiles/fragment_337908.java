Arrays.sort(books, new Comparator<String>() {
    @Override
    public int compare(String b1, String b2) {
        return String.CASE_INSENSITIVE_ORDER.compare(noThe(b1), noThe(b2));
    }
});