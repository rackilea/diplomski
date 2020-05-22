@Override
public void letMeKnow() {
    isDone = true;
    synchronized (synchObj) {
        synchObj.notifyAll();
    }
}