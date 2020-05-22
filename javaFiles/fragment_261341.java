SwingUtilities.invokeLater(new Runnable() {
    public void run() {
        screen.requestFocus();
        screen.requestFocusInWindow();
        screen.requestFocus(true);
    }
});