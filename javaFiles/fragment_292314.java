public class GameController {

    @FXML
    private BorderPane rootPane ;

    // ...

    public void showMenu(Node menu) {
        rootPane.setTop(menu);
    }

    // ...
}