// ...
.collect(
    Collectors.groupingBy(
        input -> input.getDateTime()),
        Collectors.mapping(    // <--- This
            TheClass::convertToOutput,
            Collectors.toList());