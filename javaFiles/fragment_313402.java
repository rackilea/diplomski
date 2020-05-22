SwingUtilities.invokeLater(new Runnable() {
    public void run() {
        while(notDone) {
            // Do your processing
            panel.paintImmediately(...);
        }
    }
});