package application;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FirstController implements Initializable {

    @FXML private TextField textField;
    @FXML private Button btn;
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
    }

    public void  onClick(ActionEvent event) throws Exception {
        //switching to new scene
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/application/Second.fxml"));
        loader.load();
        SecondController sn=loader.getController();
        sn.setText(textField.getText());
        Parent p=loader.getRoot();  
        Stage window=new Stage();
        window.setScene(new Scene(p));
        window.setTitle("dfd");
        window.show();
    }
}