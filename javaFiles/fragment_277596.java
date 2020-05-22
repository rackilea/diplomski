List<Foo> result = map.values()
    .stream()
    .map(foos -> {
            Foo f = new Foo();
            f.setBars(foos.stream().flatMap(
                foo -> foo.getBars().stream()).collect(toList()));
            return f;
        })
    .collect(toList());