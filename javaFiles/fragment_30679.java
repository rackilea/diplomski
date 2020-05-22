package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class FXMLDocumentController implements Initializable {

    @FXML private ChoiceBox InstrumentChoiceBox;
    @FXML private Label SelectionLabel;
    @FXML private Button selectionButton;
    static String SelectedInstrument;

    public String getSelectedInstrument(){
        return SelectedInstrument;
    }

    public void onChoiceMade(){
        SelectedInstrument = InstrumentChoiceBox.getSelectionModel().getSelectedItem().toString();
        SelectionLabel.setText("Instrument selected: "+SelectedInstrument);
        selectionButton.getScene().getWindow().hide();
    }

    private String[] determineCandidates(){
        //method to determine the list of candidates, abbreviated
        //Reads in a number of Strings from file and converts to String[]
        return new String[] {"a","b","c"};
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String[] Candidates = determineCandidates();
        SelectedInstrument = "";
        for(int i = 0; i < Candidates.length;i++) InstrumentChoiceBox.getItems().add(Candidates[i]);
        InstrumentChoiceBox.setValue(Candidates[0]);
    }
}