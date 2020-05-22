private boolean isSequenceSuccessful() {
    return Optional.of(doSomething())
            .flatMap(result1 -> doAnotherThing(result1))
            .flatMap(result2 -> doSomethingElse(result2))
            .map(result3 -> doMoreStuff(result3))
            .orElse(false);
}