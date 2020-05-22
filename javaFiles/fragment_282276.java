private static int priorityCounter = 0; // shared by all instances
private int priority; // only this instance

public CellContent(...) {
    priority = ++priorityCounter;
    ...
}