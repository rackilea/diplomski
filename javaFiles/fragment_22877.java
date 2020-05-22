class TheAncestorException extends Exception {
    public void info() { // Or possibly make it abstract
        // ...
    }
}
class Exception1 extends TheAncestorException {
    // Optionally override `info` here
}
class Exception2 extends TheAncestorException {
    // Optionally override `info` here
}