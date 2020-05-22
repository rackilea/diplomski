// and similar for other methods
public boolean doThingB() {
    if (x == 1) {
        startDifferentMethodLoop();
        return true;
    } else {
        return false;
    }
}

public void doSomething() {
    if (doThingA()) return;
    if (doThingB()) return;
    if (doThingC()) return;
    doSomething();
}