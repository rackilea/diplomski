Stream<X> exes = ....
exes.forEach(action1
    .andThen(action2)
    .andThen(action3)
    .andThen(...)
    .andThen(actionN));