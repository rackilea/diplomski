Public Stone(...) {
    // ...

    KeyboardFocusManager fm = KeyboardFocusManager.getCurrentKeyboardFocusManager();
    fm.addKeyEventDispatcher(
        new KeyEventDispatcher() {
            public boolean dispatchKeyEvent(KeyEvent e) {
                System.out.println("Key Press: " + e.getKeyChar());
                return false;
            }            
        } 
    );

   // ... 
}