public class Controller {

    @FXML private TableView<?> topTable;

    @FXML
    private void initialize() {
        topTable.setOnKeyPressed(this::copyToClipboard);
    }

    public void copyToClipboard(KeyEvent event) {}

}