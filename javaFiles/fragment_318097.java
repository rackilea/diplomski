Object foo = ...;

if (Thread.otherThreadHasLocked(foo)) {
    doSomething();
} else {
    doSomethingElse();
}