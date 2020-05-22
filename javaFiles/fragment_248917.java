Collections.sort(strs, new Comparator<String>() {
    @Override
    public int compare(String o1, String o2) {
        Collator usCollator = Collator.getInstance(Locale.US);
        return usCollator.compare(o1, o2);
    }
});