@FXML
private void onNewSampleAction(ActionEvent event) {
    sampleCounter++;
    Sample sample = new Sample("Sample " + sampleCounter);
    SampleEditorPane sampleEditorPane = new SampleEditorPane(sample);
    Dockables.inject(sampleEditorPane);
    Dockables.open(sampleEditorPane);
}