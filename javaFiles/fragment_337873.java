private boolean isSequenceSuccessful2() {
    return Optional.of(doSomething())
            .flatMap(this::doAnotherThing)
            .flatMap(this::doSomethingElse)
            .map(this::doMoreStuff)
            .orElse(false);
}