JFrame frame = new JFrame("Swing and JavaFX");
final JFXPanel fxPanel = new JFXPanel();
frame.add(fxPanel);

Platform.runLater(new Runnable() {
    @Override
    public void run() {
        // This method is invoked on the JavaFX thread
        Scene scene = ...; // Create your scene
        fxPanel.setScene(scene);
    }
});