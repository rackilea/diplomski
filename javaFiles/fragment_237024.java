public class MainController {

    @FXML
    private BorderPane root ;
    @FXML
    private ListView<String> selector ;

    @FXML
    private Parent userInfo ;
    @FXML
    private Parent prefs;
    @FXML
    private Parent appearance;

    // need controllers to get data later...

    @FXML
    private UserInfoController userInfoController ;
    @FXML
    private PreferencesController prefsController ;
    @FXML
    private AppearanceController appearanceController ;

    public void initialize() {

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