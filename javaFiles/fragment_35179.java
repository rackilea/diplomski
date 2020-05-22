public class MenuController {
    @FXML
    private Label label ;
    @FXML
    private InnerController innerPaneController ;

    public void initialize() {
        innerPaneController.textProperty().addListener((obs, oldText, newText) -> 
            label.setText(newText));
        // or just label.textProperty().bind(innerPaneController.textProperty());
    }
}