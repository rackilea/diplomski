Stream<String> allFoos =
            list.stream()
                    .map(o -> Optional.ofNullable(o)
                            .map(t -> t.nested)
                            .map(n -> n.inner)
                            .map(i -> i.foo)
                            .orElse("Missing"));