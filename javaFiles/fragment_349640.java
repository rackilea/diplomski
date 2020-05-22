public class Controller {

    @FXML
    public TextField txtField;
    @FXML
    public PasswordField passField;
    @FXML
    public Button btn;
    @FXML
    public Label access;

    private String USNM = "crimsoncoder";
    private String PASS = "toor";

    private static final String ACCESS_GRANTED = "/ACCESS_GRANTED/";
    private static final String ACCESS_DENIED = "|/?ACCESS_DENIED?/|";

    public void onClick() {

        String usnm = txtField.getText();
        String pass = passField.getText();

        String acc;

        if (usnm.equals(USNM)) {
            if (pass.equals(PASS)) {
                acc = ACCESS_GRANTED;
            } else {
                acc = ACCESS_DENIED;
            }
        } else {
            acc = ACCESS_DENIED;
        }

        System.out.println(acc);
    }

}