fooboos = foos
        .stream()
        .map(foo -> generateBoo(foo).map(boo -> new FooBoo(foo, boo))
        .filter(Optional::isPresent)
        .map(Optional::get)
        .collect(Collectors.toList());