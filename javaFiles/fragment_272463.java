public void processWidget(int wID) throws IllegalArgumentException {
    if(wID == EXECUTE_ALL) throw new IllegalArgumentException();
    originalMethod(wID);
}

public void processAllWidgets() {
    originalMethod(EXECUTE_ALL);
}