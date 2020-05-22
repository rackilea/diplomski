public class ScriptGeneratorController implements Initializable {
    @FXML
    private ListView<String> select_values;
    private ObservableList<String> selectValueList = FXCollections.observableArrayList("", "", "", "", "", "", "");

    @FXML
    private void handleQuestionGenerationAction(ActionEvent event) {
        System.out.println(selectValueList); 
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        select_values.setItems(selectValueList);
        select_values.setCellFactory(TextFieldListCell.forListView());
    }
}