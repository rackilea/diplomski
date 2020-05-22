Validation<Seq<String>, Seq<Foo>> validations = Validation.sequence(
        Stream.of(a, b, c)
            .map(v -> v.mapError(List::of))
);

Validation<String, Foo> result = validations
    .mapError(errors -> errors.collect(Collectors.joining("; ")))
    .map(combinator); // fill in with combinator function that converts
                      // a Seq<Foo> into a single Foo