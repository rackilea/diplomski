public class Presenter implements Initializable {
    // Nodes
    @FXML private Label nodeLabelName;

    // Injects
    @Inject private StateModel stateModel;

    @Override
    public void initialize(URL location, ResourceBundle resource) {
        this.nodeLabelName.textProperty().bind(this.stateModel.nameProperty());
    }
}