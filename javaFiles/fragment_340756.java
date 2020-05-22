public class CustomToggleSwitch extends Pane {

    private EventHandler<ActionEvent> myEventHandler;

    public CustomToggleSwitch() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/CustomToggleSwitch.fxml"));
        loader.setRoot(this);
        loader.setController(this);

        try {
            loader.load();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void initialize() {

    }

    @FXML
    private void click(ActionEvent event) {
        if(myEventHandler != null) {
            myEventHandler.handle(event);
        }
    }

    public EventHandler<ActionEvent> getOnMyAction() {
        return myEventHandler;
    }

    public void setOnMyAction(EventHandler<ActionEvent> onMyAction) {
        myEventHandler = onMyAction;
    }
}