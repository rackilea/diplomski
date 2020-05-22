public class FXMLDocumentController implements Initializable {

    @FXML 
    public TextArea textAreaA;

    [...]
    public void updateTextArea(String string) {
        textAreaA.setText(string);
    }
}