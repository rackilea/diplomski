public class MainWindowController {

    @FXML
    private TabPane mainTabPane;

    @FXML
    // fx:id of the fx:include with "Controller" appended
    private MainTabController mainWindowTabController ; 

    public void initialize() {
        mainWindowTabController.setMainWindowController(this);
    }

    public void createTeamTab(Team team) {
        mainTabPane.getTabs().add(new Tab(team.getTeamName()));

    }
}