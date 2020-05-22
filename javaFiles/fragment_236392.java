new Function<String, Integer>() {
    @Override
    public Integer apply(String str) {
        return aa.compareToIgnoreCase(str);
    }
};