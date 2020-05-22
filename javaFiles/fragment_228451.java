public class BaseController {

    @FXML
    private AnchorPane rootPane;

    protected AnchorPane getRootPage() {
        return rootPane;
    }

    protected void makeFadeIn() {
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setNode(rootPane);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
    }
}