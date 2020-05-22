public class ListViewPresenter {

    @Inject
    private ListViewModel viewModel ;

    @FXML
    private ListView<String> listView ;

    @FXML
    public void initialize() {
        listView.setItems(viewModel.getItems());
        viewModel.selectedItemProperty().bind(listView.getSelectionModel().selectedItemProperty());
    }
}