private boolean exceptionInInit = false;

@Override
public void init() {
    try {
        // do something
    } catch (Exception e) {
        exceptionInInit = true;
    }
}

@Override
public void start(Stage primaryStage) {
    if (exceptionInInit) {
         Alert alert = new Alert(AlertType.ERROR);
         alert.setTitle("Error Dialog");
         alert.setHeaderText("Look, an Error Dialog");
         alert.setContentText("Ooops, there was an error!");
         alert.showAndWait();

         // make sure platform shuts down even though primary stage was never shown
         Platform.exit();
    } else {
        // normal startup
    }
}