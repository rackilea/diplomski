final Map<String, AtomicInteger> map = new HashMap<>();
final AtomicInteger i = new AtomicInteger(0);
map.put("aa", i);
map.put("bbbbb", i);
map.forEach((k, v) -> {
    v.set(k.length());
    System.out.printf(" %s ", v);
});
System.out.println();
map.values().forEach(v -> System.out.printf(" %s ", v));
System.out.println();