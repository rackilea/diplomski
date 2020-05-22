public class InputController {

    @FXML
    private TextArea inputArea;
    @FXML
    private Button inputButton;

    private ObservableList<InputObject> tableItems ;

    public void setTableItems(ObservableList<InputObject> tableItems) {
        this.tableItems = tableItems ;
    }

    public void inputToTable() {
        if(! inputArea.getText().isEmpty()) {
            tableItems.add(new InputObject(inputArea.getText()));
        }
    }


}