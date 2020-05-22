private void doStuff(List<Thing> things) {
    Map<Thing, Other> otherThings = things.stream()
        .collect(toMap(x -> x, ThingHelper::generateOther));
    otherThings.forEach(this::doSomething);
    otherThings.forEach(this::doSomethingElse);
}