public void keyPressed(KeyEvent e) {
    char keyChar = e.getKeyChar();
    System.out.println("KeyChar: " + keyChar);
    // Press a to start an Action
    if (keyChar == 'a') {
        if (!mAction.isRunning()) {
            mTotalActions.setText("Ran " + (++mTotalActionsRan) + " actions.");
            System.out.println("Starting new Action");
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    mAction.run();
                }
            });
            thread.start();
        }
    }
}