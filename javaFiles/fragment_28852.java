Thread updateThread = new Thread() {
public void run() {
    Cursor hourglassCursor = new Cursor(Cursor.WAIT_CURSOR);
    setCursor(hourglassCursor);
    //Program code
    Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
    setCursor(normalCursor);
    }
};
updateThread.start();