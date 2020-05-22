public static boolean assertEventuallyTrue(EventuallyTrueBehavior behavior) {
    int remainingTries = behavior.tries;
    while (remainingTries > 0) {
        boolean succeeded = behavior.predicate();
        if (succeeded) {
            return true;
        } else {
            remainingTries -= 1;
            try {
                Thread.sleep(behavior.pauseTime);
            } catch (InterruptedException e) {}
        }
    }
    Assert.fail(behavior.timeoutMessage);
    return false;
}