Stream<X> exes = ...
exes.peek(action1)
 .peek(action2)
 .peek(action3)
 .peek(...)
 .forEach(actionN);