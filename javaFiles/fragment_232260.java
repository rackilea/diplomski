ObjectProperty<File> fileProperty = new SimpleObjectProperty<File>() { 
    /* your previous implementation */
};
fileProperty.set(new File("/path/to/some/valid/file"));
// now bind when you get the filename:
playButton.textProperty().bind(fileProperty.asString());
// setting the fileProperty to null will now invoke the binding that was provided when it wasn't null
// and you'll see a nice bunch of null pointer exceptions:
fileProperty.set(null);