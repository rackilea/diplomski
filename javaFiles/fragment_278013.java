@Override
public void start(Stage primaryStage) throws Exception{
    Parent root = FXMLLoader.load(getClass().getResource("editor.fxml"));
    primaryStage.setTitle("Simple Text Editor");
    primaryStage.setScene(new Scene(root));
    primaryStage.setMinWidth(450);
    primaryStage.setMinHeight(300);

    Screen screen = Screen.getPrimary();
    Rectangle2D bounds = screen.getVisualBounds();
    primaryStage.setWidth(bounds.getWidth());
    primaryStage.setHeight(bounds.getHeight());

    primaryStage.setMaximized(true);
    primaryStage.show();
}