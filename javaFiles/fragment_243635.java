lift((Operator) (subscriber) -> {
    // connect the upstream and downstream subscribers to keep the chain intact
    new Subscriber<CommandAction<E>>(subscriber) {
        // the implementation is the same
    }
}