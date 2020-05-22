private void doStuff(final List<Thing> things) {
    final Map<Thing, Other> otherThings = things.stream()
        .collect(Collectors.toMap(Function.identity(), ThingHelper::generateOther));
    otherThings.forEach((final Thing thing, final Other other) -> {
        doSomething(thing, other);
    });
    otherThings.forEach((final Thing thing, final Other other) -> {
        doSomethingElse(thing, other);
    });
}