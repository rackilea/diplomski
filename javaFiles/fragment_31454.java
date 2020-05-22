void iWannaCatchException() {
    try {
        IgnornableException.incrementDontIgnore();
        int x = someOptionallySignallingMethod();
    }
    catch (...) {
        ...
    }
    finally {
        IgnorableException.decrementDontIgnore();
    }
}

void iDontWannaCatchException() {
    int x = someOptionallySignallingMethod();
}

int someOptionallySignallingMethod() {
    if (somethingBad) {
        if (IgnorableException.shouldSignal()) {
            throw new BadException();
        }
    }
    return 42;
}