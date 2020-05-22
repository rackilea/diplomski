public void record(String key, String value) {
    entries.compute(key, (k, v) -> {
        List<String> vals = v;
        if(vals == null)
            vals = new ArrayList<>();
        vals.add(value);
        return vals;
    });
}