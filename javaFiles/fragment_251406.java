public class ConnectionErrorController implements Initializable {

    private MainController mainController ;

    public void setMainController(MainController mainController) {
        this.mainController = mainController ;
    }

    // ...

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        infoLabel.setText("Connection lost, please try again");
        tryButton.setText("try again");
        exitButton.setText("exit");

        tryButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                WebEngine webEngine = mainController.getContentPaneController().getVideoWebView().getEngine(); // 1
                ToggleButton playButton = mainController.getControlPaneController().getPlayButton(); // 2
                if (mainController.testInet()) {
                    mainController.play(webEngine, playButton);
                } else {
                    // obviously you can now do something better than the "public static field hack" here:
                    MainController.exist = false;
                }
                tryButton.getScene().getWindow().hide();
            }
        });

        // ...
    }
}