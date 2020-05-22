Map<Integer, Employee> employees = al.stream().collect(Collector.of(
   () -> new HashMap<>(),
   (HashMap<Integer, Employee> a, Employee b) -> {
       a.put(b.getId(), b);
   },
   (HashMap<Integer, Employee> c, HashMap<Integer, Employee> d) -> {
       c.putAll(d);
       return c;
   },
   Function.identity()
));