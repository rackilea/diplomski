public class Tester extends Application{
[...]

public void start (Stage primaryStage) throws Exception {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
    Parent root = loader.load();

    FXMLDocumentController controller = loader.getController();

    primaryStage.setTitle("App Window");
    primaryStage.setScene(new Scene(root, 300, 275));
    primaryStage.show();


    TESTER_API.TESTER_API_Connector(controller);       
}