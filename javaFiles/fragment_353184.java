public class MainWindowController {

    private MainWindowController mainWindowController ;

    public void setMainWindowController(MainWindowController mainWindowController) {
        this.mainWindowController = mainWindowController ;
    }

    @FXML
    public void handleSubmit() {
        String teamName = teamNameTextField.getText();
        Roster roster = rosterComboBox.getValue();
        int startWeek = spinner.getValue();
        Team newTeam = new Team(teamName, startWeek, roster);
        TeamData.addTeam(newTeam);
        mainWindowController.createTeamTab(newTeam);

    }

}