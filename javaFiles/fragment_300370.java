private static <T> Collector<T, ?, List<T>> limitingList(int limit) {
    return Collector.of(
                ArrayList::new, 
                (l, e) -> { if (l.size() < limit) l.add(e); }, 
                (l1, l2) -> {
                    l1.addAll(l2.subList(0, Math.min(l2.size(), Math.max(0, limit - l1.size()))));
                    return l1;
                }
           );
}