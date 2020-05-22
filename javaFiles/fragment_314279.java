Optional<String> s = Stream.of(first(), second())
                           .peek($ -> System.out.println("Hello World!"))
                           .filter(Optional::isPresent)
                           .findFirst()
                           .flatMap(Function.identity());

System.out.println(s.get());