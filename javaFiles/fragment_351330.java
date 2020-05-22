@FXML
private Spinner<String> uni;

@FXML
private ObservableList<String> unis;

@Override
public void initialize(URL url, ResourceBundle rb) {
    unis.add("Oxford");
    unis.add("Harvard");
}