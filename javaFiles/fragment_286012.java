FileChooser chooser = new FileChooser();
chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("mp4 video files", "*.mp4"));
File file = chooser.showOpenDialog(primaryStage);
if (file != null) {
    String videoURI = file.toURI().toString();
    // ...
}