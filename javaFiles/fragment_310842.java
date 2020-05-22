LinkedHashMultimap<String, String> m = LinkedHashMultimap.create();

m.put("a", "foo");
m.put("b", "bar");
m.put("a", "baz");

m.get("a").forEach(System.out::println); // outputs "foo" and "baz"