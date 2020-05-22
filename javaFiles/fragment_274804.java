import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class FXMLController {
    ViewMyAccount viewMyAccount = new ViewMyAccount();
    @FXML private Text usernameEntered;
    @FXML private TextField usernameField;

    @FXML protected void handleLogin(ActionEvent event) {
        String enteredValue = usernameField.getText().toString();
        usernameEntered.setText("Username: " + enteredValue);

        System.out.println("From Controller: " + enteredValue);

        System.out.println("From ViewMyAccount: "+ 
                viewMyAccount.setAndReturnMail(enteredValue));

        //I cannot tell why you want to call initialize from 
        //ViewMyAccount, but this is a test showing it works
        viewMyAccount.initialize(null, null); 
    }
}