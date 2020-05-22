private void doSomethingGeneric(? param, GenericWayToHandle handler) {
    while (condition) {
        Bar b = createBar();
        handler.doSomethingWith(b);
    }
}