public class Controller implements Initializable {

@FXML
public AnchorPane apMain;

@FXML
public Button button;

@FXML
public Label label;

@Override
public void initialize(URL location, ResourceBundle resources) {

}

public void handleButtonAction() {
    System.out.println("You clicked me!");
    label.setText("Hello World!");
}

public void setStage(Stage stage){
    stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
        @Override
        public void handle(WindowEvent event) {
            System.out.println(label.getText());
        }
    });
}

}