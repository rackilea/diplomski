public class ClientsViewController implements Initializable {
    @FXML
    private Button addClientButton;
    private Stage clientAddWindowStage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addClientButton.setOnAction(event -> openClientAddWindow());

        try {
            clientAddWindowStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/client-add-window.fxml"));
            clientAddWindowStage.setTitle("Dodawanie nowego klienta");
            clientAddWindowStage.initModality(Modality.APPLICATION_MODAL);
            clientAddWindowStage.setScene(new Scene(loader.load()));

            // get the controller and set this so the other controller can control it
            ClientAddWindowController controller = loader.getController();
            controller.setClientsViewController(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openClientAddWindow() {
        clientAddWindowStage.show();
    }

    public void closeClientAddWindow() {
        clientAddWindowStage.close();
    }
}