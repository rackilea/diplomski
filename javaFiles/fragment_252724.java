public static Consumer<Stateful> getStatefulConsumer(
        Function<Stateful,SimpleEntry<Integer,Integer>> getStatus,                  // extract status from Stateful
        Consumer<Stateful> applyLogic,                                              // apply business logic
        BiPredicate<SimpleEntry<Integer,Integer>,SimpleEntry<Integer,Integer>> compareState, // test statuses for change
        Consumer<Stateful> onChange)                                                // doSomethingElse
{
    return stateful -> {
        SimpleEntry<Integer,Integer> oldStatus = getStatus.apply(stateful);
        applyLogic.accept(stateful);
        if(!compareState.test(oldStatus, getStatus.apply(stateful))){
            onChange.accept(stateful);
        }   
    };
}