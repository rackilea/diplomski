public class AddItemPresenter {

    @Inject
    private AddItemViewModel viewModel ;

    @FXML
    private TextField textField ;

    @FXML
    private Button addButton ;

    @FXML
    public void initialize() {
        viewModel.currentItemProperty().bindBidirectional(textField.textProperty());
        addButton.setOnAction(e -> viewModel.getAddItemAction().run());
    }
}