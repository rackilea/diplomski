public void copyToClipboard(KeyEvent event) {
    if (event.isShortcutDown() && event.getCode() == KeyCode.C) {
        Clipboard cp = Clipboard.getSystemClipboard();
        // add your data to the clipboard
    }    
}