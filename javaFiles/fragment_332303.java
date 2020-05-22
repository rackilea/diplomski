public class ProgressBarController {

    @FXML
    private ProgressBar pBar;
    @FXML
    private Label task;

    public DoubleProperty progressProperty() {
        return pBar.progressProperty();
    }

    public StringProperty textProperty() {
        return task.textProperty();
    }

}