public class ControlsController extends BaseController{
    @FXML
    private Slider slAcceleration;

    public void initialize() {
        slAcceleration.valueProperty().addListener((obs, oldValue, newValue) -> {
            System.out.println(newValue.doubleValue());
        });
    }
}