addWindowListener(new java.awt.event.WindowAdapter() {
    public void windowClosed(java.awt.event.WindowEvent evt) {
        end = true;
        System.exit(0);
        // or this.dispose();
    }
});