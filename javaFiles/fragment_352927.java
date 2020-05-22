public class ListPresenter {

    @Inject
    private Model model ;

    @FXML
    private ListView<String> listView ;

    @FXML
    public void initialize() {
        listView.setItems(model.getItemList());
    }
}