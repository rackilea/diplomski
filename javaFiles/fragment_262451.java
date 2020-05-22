default public boolean tryHeads() {
    return flip();
}

default public boolean tryTails() {
    return !flip();
}

private boolean flip() {
    return ThreadLocalRandom.current().nextBoolean();
}