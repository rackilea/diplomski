Arrays.sort(arr, new Comparator<String>() {
    @Override
    public int compare(String s1, String s2) {
        return Utils.compareByLength(s1, s2);
    }
});