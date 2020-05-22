public class CloseRequestHandler implements EventHandler<ActionEvent> {

    private final View view ;

    public CloseRequestHandler(View view) {
        this.view = view ;
    }

    @Override
    public void handle(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("This will reset the game.");
        alert.setContentText("Are you sure?");
        alert.setTitle("Warning");
        alert.getButtonTypes().clear();
        ButtonType no = new ButtonType("No");
        ButtonType yes = new ButtonType("Yes");
        alert.getButtonTypes().addAll(no, yes);
        alert.showAndWait();
        if (alert.getResult() == null || alert.getResult().equals(no)) {
            event.consume();
        }
        if (alert.getResult().equals(yes)) {

            // this line of code doesn't do anything, btw:
            view.getTextField() ;

            view.getScene().getWindow().hide();
        }
    }
}