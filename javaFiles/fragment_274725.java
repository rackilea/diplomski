public class AlertWithIcon
extends Application {
    @Override
    public void start(Stage stage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
            "Are you sure you want to delete this item?",
            ButtonType.YES, ButtonType.NO);
        alert.setHeaderText("Delete Item");

        DialogPane pane = alert.getDialogPane();

        ObjectProperty<ButtonType> result = new SimpleObjectProperty<>();
        for (ButtonType type : pane.getButtonTypes()) {
            ButtonType resultValue = type;
            ((Button) pane.lookupButton(type)).setOnAction(e -> {
                result.set(resultValue);
                pane.getScene().getWindow().hide();
            });
        }

        pane.getScene().setRoot(new Label());
        Scene scene = new Scene(pane);

        Stage dialog = new Stage();
        dialog.setScene(scene);
        dialog.setTitle("Delete Item");
        dialog.getIcons().add(new Image("GenericApp.png"));

        result.set(null);
        dialog.showAndWait();

        System.out.println("Result is " + result);
    }
}