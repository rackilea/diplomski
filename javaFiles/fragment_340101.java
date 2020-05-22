public class Sec implements Initializable{

    ...
    private String result = null;

    public String getResult() {
        return result;
    }

    public void setCombo() {
        result = textfield.getText();
        textField.getScene().getWindow().hide();
    }

    ...

}