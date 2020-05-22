static Timer mTimer = null;

onCreate() {
    if (mTimer == null)
        mTimer = new Timer();
    } else {
        // You shouldn't have to do nothing because your timer should be running
    }
}