public String doEverything() {
    ...
    String intermediateResult = ...;
    Thread t = new Thread(...);
    t.start(); // launch the thread to compute the rest asynchronously
    return intermediateResult;
}