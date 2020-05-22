BinaryOperator<ConcurrentHashMap<String,Set<String>>> combiner = (o,o2) -> {
        ConcurrentHashMap<String,Set<String>> res = new ConcurrentHashMap<>(o);
        o2.forEach((key, set) -> set.forEach(string -> res.computeIfAbsent(key, k -> new HashSet<>())
                                                          .add(string)));
        return res;
    };