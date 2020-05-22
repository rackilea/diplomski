Stream<Supplier<Optional<String>>> stream = Stream.of(Test::first, Test::second);

Optional<String> s = stream.map(Supplier::get)
                           .filter(Optional::isPresent)
                           .findFirst()
                           .flatMap(Function.identity());

System.out.println(s.get());