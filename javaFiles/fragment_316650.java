public class FXMLLoader {

    // not a real method, but functionally equivalent to the load()
    // method for the example FXML above:
    public BorderPane load() {

        example.Controller controller = new example.Controller();
        this.controller = controller ;

        BorderPane borderPane = new BorderPane();
        this.root = borderPane ;

        Label header = new Label();
        controller.header = header ;
        borderPane.setTop(header);

        HBox hbox = new HBox();
        Button okButton = new Button();
        okButton.setText("OK");
        controller.okButton = okButton ;
        hbox.getChildren().add(okButton);

        Button cancelButton = new Button();
        cancelButton.setText("Cancel");
        controller.cancelButton = cancelButton ;
        hbox.getChildren().add(cancelButton);

        borderPane.setBottom(hbox);

        controller.initialize();

        return borderPane ;

    }
}