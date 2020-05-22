private String name = "none set";

@Override
public void start(Stage primaryStage) throws Exception{
    name = "set in start";
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sample.fxml"));
    fxmlLoader.setController(new Main());
    Parent root = (Parent)fxmlLoader.load();
    primaryStage.setTitle("Hello World");
    primaryStage.setScene(new Scene(root, 300, 275));
    primaryStage.show();
}

@FXML
public void menuItemActionMethod(ActionEvent event) {
    System.out.println("In menuItemActionMethod: " + name);
}