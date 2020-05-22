Collections.sort(strs, new Comparator<String>() {
    @Override
    public int compare(String o1, String o2) {
        o1 = Normalizer.normalize(o1, Normalizer.Form.NFD);
        o2 = Normalizer.normalize(o2, Normalizer.Form.NFD);
        return o1.compareTo(o2);
    }
});