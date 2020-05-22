private int myInt;
private boolean isMyIntLocked = false;

public boolean setMyInt(int value) {
    if (isMyIntLocked) {
        Log.i(TAG, "cannot set myInt, it's been locked");
        return false;
    } else {
        this.myInt = value;
        return true;
    }
}

public void lockMyInt(boolean doLock) {
    this.isMyIntLocked = doLock;
}