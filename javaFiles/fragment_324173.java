Stream.of( 1, 2, 3, 1, 4, 5 )
        .collect( Collectors.toMap(
                key -> key,
                value -> value,
                ( oldValue, newValue ) -> newValue,
                () -> new LinkedHashMap<>( 16, 0.75f, true )
        ) )
        .values()
        .stream()
        .forEach( System.out::println );