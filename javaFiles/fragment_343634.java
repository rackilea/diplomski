public class AxisController implements Initializable{

    @FXML
    private AnchorPane anchr;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
         assert anchr != null : "fx:id=\"anchr\" was not injected: check your FXML file 'AxisFxml.fxml'.";

    }

    @FXML
    private void handleClick(MouseEvent event) {
        System.out.println(event.getX());
        System.out.println(event.getY());
    }
}