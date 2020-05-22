public class MyApp extends Application {

    @Override
    public void start(Stage primaryStage) {

        // make sure application doesn't exit when we close the dialog window:
        Platform.setImplicitExit(false);

        Stage popup = new Stage();
        TextField resolutionField = new TextField();
        // ... populate popup, etc...

        popup.setOnHidden(() -> {

            int resolution = Integer.parseInt(resolutionField.getText());

            // now create main UI...

            primaryStage.show();
        });

        popup.show();
    }
}