public class ConfirmationController {

    private final BookingModel model ;

    @FXML
    private Button confirmButton ;
    @FXML
    private Label arrivalLabel ;
    @FXML
    private Label departureLabel ;

    public ConfirmationController(BookingModel model) {
        this.model = model ;
    }

    public void initialize() {

        confirmButton.textProperty().bind(Bindings
                .when(model.confirmedProperty())
                .then("Cancel")
                .otherwise("Confirm"));

        arrivalLabel.textProperty().bind(model.arrivalProperty().asString("Arrival: %s"));
        departureLabel.textProperty().bind(model.departureProperty().asString("Departure: %s"));
    }

    @FXML
    private void confirmOrCancel() {
        model.setConfirmed(! model.isConfirmed());
    }

    @FXML
    private void goToDeparture() {
        model.setScreen(Screen.DEPARTURE);
    }
}