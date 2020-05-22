public class MainController {

    @FXML
    private BorderPane root ;
    @FXML
    private ListView<String> selector ;

    private Parent userInfo ;
    private Parent prefs;
    private Parent appearance;

    // need controllers to get data later...

    private UserInfoController userInfoController ;
    private PreferencesController prefsController ;
    private AppearanceController appearanceController ;

    public void initialize() throws IOException {

        FXMLLoader userInfoLoader = new FXMLLoader(getClass().getResource("userInfo.fxml));
        userInfo = userInfoLoader.load();
        userInfoController = userInfoLoader.getController();

        FXMLLoader prefsLoader = new FXMLLoader(getClass().getResource("preferences.fxml));
        prefs = prefsLoader.load();
        prefsController = prefsLoader.getController();

        FXMLLoader appearanceLoader = new FXMLLoader(getClass().getResource("appearance.fxml));
        appearance = appearanceLoader.load();
        appearanceController = appearanceLoader.getController();

        // configure controllers with data if needed...

        selector.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if ("User Information".equals(newSelection)) {
                root.setCenter(userInfo);
            } else if ("Preferences".equals(newSelection)) {
                root.setCenter(prefs); 
            } else if ("Appearance".equals(newSelection)) {
                root.setCenter(prefs);
            } else {
                root.setCenter(null);
            }
        }
    }
}