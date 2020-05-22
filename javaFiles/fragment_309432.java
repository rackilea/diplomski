List<Factory> list = Stream.concat(
    Arrays.asList(
        new Factory0(), new Factory1(), new Factory2(), 
        new Factory3(), new Factory4(), new Factory5()
    ).stream(),
    FactoryWithArgsMaker.makeNew(0, 100).stream()
).collect(Collectors.toList());