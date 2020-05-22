@Override
public void notifyAllObservers() {
    for (Observer o : observers) {
        o.update();
    }
}