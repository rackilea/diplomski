public class InterfaceHandler implements Initializable {
    @FXML
    public Label nameLabel;
    @FXML
    public Label locationLabel;    

    public void handleButton(ActionEvent event) throws IOException {        
        locationLabel.setText("Town");
    }

    public void setName(String name){       
        nameLabel.setText(name);
    }    
}