public class DepartureController {
    private final BookingModel model ;

    @FXML
    private DatePicker departurePicker ;

    @FXML
    private Label arrivalLabel ;

    @FXML
    private Button nextButton ;

    public DepartureController(BookingModel model) {
        this.model = model ;
    }

    public void initialize() {
        model.setDeparture(null);

        departurePicker.setDayCellFactory(/* cell only enabled if date is after arrival ... */);

        departurePicker.valueProperty().bindBidirectional(model.departureProperty());

        departurePicker.disableProperty().bind(model.confirmedProperty());

        arrivalLabel.textProperty().bind(model.arrivalProperty().asString("Arrival date: %s"));

        nextButton.disableProperty().bind(model.departureProperty().isNull());

    }


    @FXML
    private void goToArrival() {
        model.setScreen(BookingModel.Screen.ARRIVAL);
    }

    @FXML
    private void goToConfirmation() {
        model.setScreen(BookingModel.Screen.CONFIRMATION);
    }
}