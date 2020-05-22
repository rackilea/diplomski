public class Controller {

   @FXML 
   Button loginButton;

   @FXML 
   private void handleButtonAction() {

      Parent tableViewParent = FXMLLoader.load(getClass().getResource("../FXML/MainMenu.fxml"));
      Scene tableViewScene = new Scene(tableViewParent);

      // Instead of retrieving the stage by the event's source, you can do it by one of your FXML component.
      Stage window = (Stage) loginButton.getScene().getWindow();
      window.setScene(tableViewScene);
      window.show();
   }


   @FXML
   public void initialize() {
      //initialize the field you want here.
   }
}