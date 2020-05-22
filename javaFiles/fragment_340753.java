public class CustomToggleSwitch extends Pane {

    private ObjectProperty<EventHandler<ActionEvent>> onMyAction = new SimpleObjectProperty<EventHandler<ActionEvent>>();

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
        if(onMyAction.get() != null) {
            onMyAction.get().handle(event);
        }
    }

    public EventHandler<ActionEvent> getOnMyAction() {
        return onMyAction.get();
    }

    public ObjectProperty<EventHandler<ActionEvent>> onMyActionProperty() {
        return onMyAction;
    }

    public void setOnMyAction(EventHandler<ActionEvent> onMyAction) {
        this.onMyAction.set(onMyAction);
    }
}