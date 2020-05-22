new Comparator<String>() {
    @Override
    public int compare(String s, String str) {
        return s.compareToIgnoreCase(str);
    }
};