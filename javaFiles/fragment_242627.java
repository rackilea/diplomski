Map<String, List<A>> foo = new HashMap<>();
Map<String, List<?>> bar = foo;   // Disallowed, but let's suppose it's allowed
List<B> baz = new ArrayList<>();
baz.add(new B());
bar.put("baz", baz);
foo.get("baz").get(0);            // Oops, this is actually a B, not an A