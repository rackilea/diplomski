return Optional.ofNullable(setContainer.getSet())
    .flatMap(set -> set.stream()
        .filter(e ->  "SomeValue".equals(e.getCode()))
        .map(SetElement::getValue)
        .findAny())
    .orElse(null);