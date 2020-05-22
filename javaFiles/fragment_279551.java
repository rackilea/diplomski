Collection<MyObject> result = Stream.of(s1, s2, s3, s4)
        .map(MyObject::new)
        .filter(o -> "Active".equals(o.getState()))
        .sorted(Comparator.comparing(MyObject::getValue).reversed())
        .collect(Collectors.toMap(o -> Arrays.asList(o.getId(), o.getName()), 
                Function.identity(), (o1, o2) -> o1, LinkedHashMap::new))
        .values();

result.forEach(System.out::println);