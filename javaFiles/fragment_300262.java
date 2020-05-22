public class ErrorController {

    private static Stage stage;
    private static Parent root;

    public ErrorController(){}
    public ErrorController(Window owner) throws IOException {
        if (root == null)
            root = FXMLLoader.load(ClassLoader
                    .getSystemResource("views/Error.fxml"));
        if (stage == null)
            stage = new Stage();
        //stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(owner);
        stage.setTitle("Error");
        stage.setScene(new Scene(root));
    }
    public void show() {
        stage.show();
    }
    public @FXML void hide() {
        stage.hide();
    }
}