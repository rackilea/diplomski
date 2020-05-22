public class RootLayoutController {

    private final ObjectProperty<File> selectedFile = new SimpleObjectProperty<>(this, "selectedFile");
    public final ObjectProperty<File> selectedFileProperty() {
        return selectedFile ;
    }
    public final File getSelectedFile() {
        return selectedFile.get();
    }
    public final void setSelectedFile(File file) {
        this.selectedFile.set(file);
    }

    @FXML
    private void handleOpen() {
        fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("."));
        extFilter1 = new FileChooser.ExtensionFilter("XML Documents (*.xml)", "*.xml");
        extFilter2 = new FileChooser.ExtensionFilter("All Files", "*.*");
        fileChooser.getExtensionFilters().addAll(extFilter1, extFilter2);

        xmlFile = fileChooser.showOpenDialog(mainApp.getPrimaryStage());

        if (xmlFile != null) {
            setSelectedFile(xmlFile);
        }
    }

    // ...
}