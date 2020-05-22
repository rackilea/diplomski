//You are currently in a separate thread that's calculating your rabbit positions
SwingUtilities.invokeLater(new Runnable() {
    public void run() {
        //Put in code to modify your Swing elements
    }
});