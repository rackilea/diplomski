public class ClientAddWindowController implements Initializable {
    @FXML
    private Button saveButton;

    private ClientsViewController clientsViewController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        saveButton.setOnAction(event -> saveClient());
    }

    public void setClientsViewController(ClientsViewController clientsViewController) {
        this.clientsViewController = clientsViewController;
    }

    @FXML
    public void saveClient() {
        // ...
        clientsViewController.closeClientAddWindow();
    }
}