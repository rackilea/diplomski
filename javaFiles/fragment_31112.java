KeyboardFocusManager kfm = DefaultKeyboardFocusManager.getCurrentKeyboardFocusManager();
kfm.addKeyEventDispatcher(new KeyEventDispatcher() {
    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {
        if (DefaultKeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner() == jfxPanel) {
            if (e.getID() == KeyEvent.KEY_TYPED && e.getKeyChar() == 10) {
                e.setKeyChar((char) 13);
            }
        }
        return false;
    }
});