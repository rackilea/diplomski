List<ObjectA> firstlist = new ArrayList<>();
firstlist.add(new ObjectA(3, Arrays.asList("test", "test2")));
List<ObjectB> secondList = new ArrayList<>();
secondList.add(new ObjectB("test", 3));

List<ObjectC> result = firstlist.stream()
        .flatMap(a -> secondList.stream()
                .filter(b -> a.getNames().contains(b.getName()))
                .map(c -> new ObjectC(a.getId(), c.getName(), c.getAge()))
        ).collect(Collectors.toList());