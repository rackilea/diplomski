public class FXMLDocumentController {

    @FXML
    private Circle circle1;
    private Circle[] c;

    public void initialize() {
        c = new Circle[] { circle1 };
    }

    public void addNumber(ActionEvent event) {
        c[0].setLayoutX(355.0);
        c[0].setLayoutY(100.0);
        c[0].setVisible(true);
    }
}