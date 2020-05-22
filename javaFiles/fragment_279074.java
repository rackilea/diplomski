String data = readData();
SwingUtilities.invokeLater(new Runnable() {
    public void run() {
        gui.dataHasBeenReceived(data);
    }
});