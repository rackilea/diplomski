List<List<String>> list;
Collections.sort(list, new Comparator<List<String>> () {
    @Override
    public int compare(List<String> a, List<String> b) {
        return a.get(1).compareTo(b.get(1));
    }
});