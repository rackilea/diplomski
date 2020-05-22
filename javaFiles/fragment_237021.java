public class MainController {

    @FXML
    private BorderPane root ;
    @FXML
    private ListView<String> selector ;

    private UserInfoController userInfoController = new UserInfoController();
    private PreferencesController preferencesController = new PreferencesController();
    private AppearanceController appearanceController = new AppearanceController();

    public void initialize() {
        // initialize controllers with data if necessary...

        selector.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
        selector.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if ("User Information".equals(newSelection)) {
                loadScreen("UserInfo.fxml", userInfoController);
            } else if ("Preferences".equals(newSelection)) {
                loadScreen("Preferences.fxml", preferencesController);
            } else if ("Appearance".equals(newSelection)) {
                loadScreen("Appearance.fxml", appearanceController);
            } else {
                root.setCenter(null);
            }
        }
    }

    private void loadScreen(String resource, Object controller) {
        // as before...
    }
}