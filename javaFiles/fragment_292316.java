public class GameController {

    @FXML
    private BorderPane rootPane ;

    private ApplicationViewState viewState ;

    public void setViewState(ApplicationViewState viewState) {
        this.viewState = viewState ;
        rootPane.topProperty().bind(viewState.menuProperty());
    }

    // ...
}