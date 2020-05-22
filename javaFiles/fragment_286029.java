public class testController implements Initializable{

    @FXML
    private TextField t1;

    public void initialize() {

        System.out.println("hi");

        //You should not re-initialize your textfield
        //t1 = new TextField("j");

        t1.setText("hi");

    }
}