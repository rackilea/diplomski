public class ButtonPanelController implements Initializable {

    // We can use a single instance of each image (which is not a node)
    // and share it between 
    // multiple image views, so we can make the images static 
    // to conserve memory. Note that fairly spectacularly bad things
    // will happen if there is an exception thrown loading these images...

    private static Image playImage = 
        new Image(ButtonPanelController.class.getResource("play.png").toExternalForm());
    private static Image pauseImage = 
        new Image(ButtonPanelController.class.getResource("pause.png").toExternalForm());

    // But each controller *must* have its own imageview to display in
    // the button in its view:

    private ImageView buttonGraphic ;

    @FXML
    Button myButton

    ButtonModel model

    public ButtonPanelController(ButtonModel model) {
        this.model = model;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buttonGraphic = new ImageView();
        myButton.setGraphic(buttonGraphic);
        model.setPaused(true);
        buttonGraphic.imageProperty().bind(Bindings
            .when(model.pausedProperty())
            .then(playImage)
            .otherwise(pauseImage));
    }

    public void buttonClickedAction(ActionEvent e) {
        model.togglePaused();
    }
}