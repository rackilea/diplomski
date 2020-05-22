private void updateAB() {
    ...
    synchronized(this) {
        // Computing the new a and b values
        a = ... * increaseVal;
        b = ... * increaseVal;
    }
    ...
}