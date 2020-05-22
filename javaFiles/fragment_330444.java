public static <T> Collector<T,?,Map<T,Set<T>>> groupingBy(BiPredicate<T,T> p) {
    return Collector.of(HashMap::new,
        (map,t) -> {
            for(Map.Entry<T,Set<T>> e: map.entrySet())
                if(p.test(t, e.getKey())) {
                    e.getValue().add(t);
                    return;
                }
            map.computeIfAbsent(t, x->new HashSet<>()).add(t);
        }, (m1,m2) -> {
            if(m1.isEmpty()) return m2;
            m2.forEach((t,set) -> {
                for(Map.Entry<T,Set<T>> e: m1.entrySet())
                    if(p.test(t, e.getKey())) {
                        e.getValue().addAll(set);
                        return;
                    }
                m1.put(t, set);
            });
            return m1;
        }
    );