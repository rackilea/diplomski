private <T extends Throwable> Collection<T> aggregateSubClassExceptions(Throwable inputEx, Class<T> type) {

    Collection<T> returnItems = new ArrayList<>();
    Throwable exc = inputEx;
    while (exc != null) {
        if (type.isInstance(exc)) {
            returnItems.add(type.cast(exc));
        }
        exc = exc.getCause();
    }

    return returnItems;
}