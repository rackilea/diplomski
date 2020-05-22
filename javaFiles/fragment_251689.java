public class Main extends Application {

@Override
public void start(Stage primaryStage) throws Exception{
    FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
    Parent root = (Parent) loader.load();
    primaryStage.setTitle("Hello World");
    primaryStage.setScene(new Scene(root, 300, 275));
    primaryStage.show();

    Controller controller = (Controller)loader.getController();
    controller.setStage(primaryStage);
}


public static void main(String[] args) {
    launch(args);
}

}