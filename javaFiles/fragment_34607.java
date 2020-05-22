Map<String, Integer> map = new HashMap<>();
    for (String w : words) {
        Integer n = map.get(w);
        n = (n == null) ? 1 : ++n;
        map.put(w, n);
    }