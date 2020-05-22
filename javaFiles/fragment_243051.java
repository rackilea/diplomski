public class MainController {

    @FXML
    private TextField source ;

    @FXML
    private CustomBox cbox ;

    public String getText() {
        return source.getText();
    }

    @FXML
    protected void initialize() {
        cbox.setMainController(this);
    }
}