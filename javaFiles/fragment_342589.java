default void forEachRemaining(Consumer<? super Integer> action) {
    if (action instanceof IntConsumer) {
    //   action's implementation is an example of Class Adapter Design Pattern
    //                                   |
        forEachRemaining((IntConsumer) action);
    }
    else {
    //  method reference expression is an example of Object Adapter Design Pattern
    //                                        |
        forEachRemaining((IntConsumer) action::accept);
    }
}