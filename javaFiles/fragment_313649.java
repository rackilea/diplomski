public class DialogController implements Initializable {     
    @FXML
    private AnchorPane dialog;
    @FXML
    private Label lb_size;
    private Setting settings = null;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {}

    public void setSettings(Settings settings, int size) {
        this.settings = settings;
        this.lb_size.setText("" + size);
    }
}