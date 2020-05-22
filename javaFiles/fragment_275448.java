volatile private boolean mouseDown = false;

public void mousePressed(MouseEvent e) {
    if (e.getButton() == MouseEvent.BUTTON1) {
        mouseDown = true;
        initThread();
    }
}

public void mouseReleased(MouseEvent e) {
    if (e.getButton() == MouseEvent.BUTTON1) {
        mouseDown = false;
    }
}

volatile private boolean isRunning = false;
private synchronized boolean checkAndMark() {
    if (isRunning) return false;
    isRunning = true;
    return true;
}
private void initThread() {
    if (checkAndMark()) {
        new Thread() {
            public void run() {
                do {
                    //do something
                } while (mouseDown);
                isRunning = false;
            }
        }.start();
    }
}