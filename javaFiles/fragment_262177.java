public class Controller {

    @FXML private ScrollPane sp;

    @FXML
    private void initialize() {
        // may want to remove the listener once it does its job
        sp.skinProperty().addListener((obs, ov, nv) -> {
            if (nv != null) {
                sp.getChildrenUnmodifiable().get(0).setCache(false);
            }
        });
    }

}