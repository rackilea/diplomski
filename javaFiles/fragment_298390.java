public static void main(String[] args) {
    launch(args);
}

@Override
public void start(final Stage primaryStage) {

    BorderPane pane = null;
    try {
        pane = (BorderPane) FXMLLoader.load(MAIN.class.getResource("FILE.fxml"));
        pane.getStyleClass().add("main");
    } catch (IOException ex) {

        Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        System.exit(-1);
    }

    primaryStage.setScene(new Scene(pane, 1100, 620));
    primaryStage.getScene().getStylesheets().add(MAIN.class.getResource("FILE.css").toExternalForm());
    primaryStage.centerOnScreen();
    primaryStage.setTitle("Title");
    primaryStage.show();


}