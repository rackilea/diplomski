Stream.of(/* your objects here */)
        .anyMatch(
            ((Predicate)(Foo.class::isInstance))
                    .or(FooBar.class::isInstance)
                    .or(Bar.class::isInstance)
        );
 }