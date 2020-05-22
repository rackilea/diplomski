public class MainController {

    @FXML
    private BorderPane root ;
    @FXML
    private ListView<String> selector ;

    private Settings settings = new Settings() ; // or pass in from somewhere else..

    public void initialize() {
        selector.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if ("User Information".equals(newSelection)) {
                loadScreen("UserInfo.fxml", new UserInfoController(settings.getUserInfo()));
            } else if ("Preferences".equals(newSelection)) {
                loadScreen("Preferences.fxml", new PreferencesController(settings.getPreferences()));
            } else if ("Appearance".equals(newSelection)) {
                loadScreen("Appearance.fxml", new AppearanceController(settings.getAppearance()));
            } else {
                root.setCenter(null);
            }
    }

    private void loadScreen(String resource, Object controller) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(resource));
            loader.setController(controller);
            root.setCenter(loader.load());
        } catch (IOException exc) {
            exc.printStackTrace();
            root.setCenter(null);
        }
    }
}