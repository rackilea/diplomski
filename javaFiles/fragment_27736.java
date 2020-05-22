// get Accelerator text
    // KeyStroke accelerator
    String acceleratorText = "";
    if (accelerator != null) {
        int modifiers = accelerator.getModifiers();
        if (modifiers > 0) {
            acceleratorText = KeyEvent.getKeyModifiersText(modifiers);
            acceleratorText += UIManager.getString("MenuItem.acceleratorDelimiter");
        }

        int keyCode = accelerator.getKeyCode();
        if (keyCode != 0) {
            acceleratorText += KeyEvent.getKeyText(keyCode);
        } else {
            acceleratorText += accelerator.getKeyChar();
        }
    }
    return acceleratorText;