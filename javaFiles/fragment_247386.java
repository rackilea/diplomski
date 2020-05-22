/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

public class FXMLDocumentController implements Initializable {

    public int currentTab;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="code4"
    private TextArea code4; // Value injected by FXMLLoader

    @FXML // fx:id="code3"
    private TextArea code3; // Value injected by FXMLLoader

    @FXML // fx:id="code2"
    private TextArea code2; // Value injected by FXMLLoader

    @FXML // fx:id="fileName"
    private TextField fileName; // Value injected by FXMLLoader

    @FXML // fx:id="code1"
    private TextArea code1; // Value injected by FXMLLoader

    @FXML // fx:id="saveAs"
    private MenuItem saveAs; // Value injected by FXMLLoader

    @FXML // fx:id="tab3"
    private Tab tab3; // Value injected by FXMLLoader

    @FXML // fx:id="save"
    private MenuItem save; // Value injected by FXMLLoader

    @FXML // fx:id="about"
    private MenuItem about; // Value injected by FXMLLoader

    @FXML // fx:id="tab4"
    private Tab tab4; // Value injected by FXMLLoader

    @FXML // fx:id="tab1"
    private Tab tab1; // Value injected by FXMLLoader

    @FXML // fx:id="run"
    private Button run; // Value injected by FXMLLoader

    @FXML // fx:id="tab2"
    private Tab tab2; // Value injected by FXMLLoader

    @FXML // fx:id="code5"
    private TextArea code5; // Value injected by FXMLLoader

    @FXML // fx:id="errorMsg"
    private Button errorMsg; // Value injected by FXMLLoader

    @FXML // fx:id="tab5"
    private Tab tab5; // Value injected by FXMLLoader

    @FXML // fx:id="lines"
    private Text lines; // Value injected by FXMLLoader

    @FXML // fx:id="newN"
    private MenuItem newN; // Value injected by FXMLLoader

    @FXML // fx:id="close"
    private MenuItem close; // Value injected by FXMLLoader

    @FXML
    void change1(Event event) {

    }

    @FXML
    void change2(Event event) {

    }

    @FXML
    void change3(Event event) {

    }

    @FXML
    void change4(Event event) {

    }

    @FXML
    void change5(Event event) {

    }

    @FXML
    void newNOnAction(ActionEvent event) {

    }

    @FXML
    void saveOnAction(ActionEvent event) {

    }

    @FXML
    void saveAsOnAction(ActionEvent event) {

    }

    @FXML
    void closeOnAction(ActionEvent event) {

    }

    @FXML
    void aboutOnAction(ActionEvent event) {

    }

    @FXML
    void fileNameOnAction(KeyEvent event) {

    }

    @FXML
    void runOnAction(ActionEvent event) {

    }

    @FXML
    void errorMsgOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}