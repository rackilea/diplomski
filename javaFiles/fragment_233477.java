public void delete(String key, String value) {
    entries.compute(key, (k, v) -> {
        List<String> vals = v;
        if(vals == null)
            return null; // No mapping, return null to keep the status quo

        vals.remove(value); // Or whatever you intend to do
        return vals.isEmpty() ? null : vals;
    });
}