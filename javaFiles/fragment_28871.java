public class Myclass implements Initializable{

    @FXML private TextArea txta;
    @FXML private Button btn;
    private String msg;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        msg="Hello World";
        txta.setText(msg);

        btn.setOnAction(e->{
            msg=msg+"\nHallo Again!!";
            txta.setText(msg);
        });
    }
}