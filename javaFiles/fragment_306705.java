interface DoesStuff {
    void doStuff();
}

interface DoesOtherStuff {
    void doOtherStuff();
}

class B implements DoesStuff, DoesOtherStuff {
    void doStuff() {
        // stuff
    }

    void doOtherStuff() {
        // other stuff
    }
}