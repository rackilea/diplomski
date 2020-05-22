Stream<String> allFoos =
        list.stream()
                .map(o -> Optional.ofNullable(o)
                        .map(t -> t.nested)
                        .map(n -> n.inner)
                        .map(i -> i.foo))
                .filter(s -> s.isPresent())
                .map(s -> s.get());