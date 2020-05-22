Map<String, Integer> map = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    map.put("Foo", 1);
    map.put("fOo", 2);

    System.out.println(map.get("foo")); // prints 2
    System.out.println(map.keySet()); // prints [Foo]