public BigDecimal addFields(List<Thing> things) {
    return things.parallelStream()
        .flatMap(thing -> Stream.of(thing.getField1(), thing.getField2()))
        .filter(Objects::nonNull)
        .reduce(BigDecimal.ZERO, BigDecimal::add);
}
public BigDecimal addOtherFields(List<Thing> things) {
    return things.parallelStream()
        .flatMap(thing ->
            Stream.of(thing.getOtherField2(), thing.getOtherField3())
                .filter(Objects::nonNull)
                .map(thing.getOtherField1()::subtract)
        ).reduce(BigDecimal.ZERO, BigDecimal::add);
}