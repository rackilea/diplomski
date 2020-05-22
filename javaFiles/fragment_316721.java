public class ArrivalController {

    private final BookingModel model ;

    @FXML
    private DatePicker arrivalPicker ;

    @FXML
    private Button nextButton ;

    public ArrivalController(BookingModel model) {
        this.model = model ;
    }

    public void initialize() {

        arrivalPicker.valueProperty().bindBidirectional(model.arrivalProperty());

        arrivalPicker.disableProperty().bind(model.confirmedProperty());

        nextButton.disableProperty().bind(model.arrivalProperty().isNull());
    }

    @FXML
    private void goToDeparture() {
        model.setScreen(BookingModel.Screen.DEPARTURE);
    }
}