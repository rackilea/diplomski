interface MyObserver {
    public void stateChangeEvent();
    public void otherEvent();
}

class MyObserverAdapter implements MyObserver {
    public void stateChangeEvent() {
         // some default implementation or no implementation.
    }

    public void otherEvent() {
         // some default implementation or no implementation.
    }
}

class MyStateChangeObserver extends MyObserverAdapter {
    public void stateChangeEvent() {
         // implement behavior specific to this class.
    }
}

class MyOtherObserver extends MyObserverAdapter {
    public void otherEvent() {
         // implement behavior specific to this class.
    }
}