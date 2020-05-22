List<Integer> ids = Arrays.asList(1, 2, 3);
List<Foo> foos = Arrays.asList(new Foo("2"), new Foo("1"), new Foo("4"));

List<Foo> result =
    ids.stream()
       .map(id -> foos.stream().filter(foo -> foo.getId().equals(id.toString())).findFirst())
       .filter(Optional::isPresent)
       .map(Optional::get)
       .collect(Collectors.toList());