List<List<SingleCell>> grid =
    Stream.generate(()->
        Stream.generate(SingleCell::new)
        .limit(width)
        .collect(Collectors.toList())
    )
    .limit(height)
    .collect(Collectors.toList());