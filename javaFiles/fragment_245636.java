SwingUtilities.invokeLater(new Runnable() {
    @Override
    public void run() {
        new Application().createAndShowGui();
    }
});