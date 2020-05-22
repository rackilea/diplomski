PlatformImpl.startup(() -> {
    FileChooserd = new FileChooser();
    d.showOpenDialog(null);
});

 new JFXPanel();
 Platform.runLater(() -> {
     FileChooser d = new FileChooser();
     d.showOpenDialog(null);
 });