public class PersonOverviewController implements Initializable{

    @FXML 
    BorderPane paneWithControls;
    @FXML
    MenuItem menuItem;
    @FXML
    Label text;



    @FXML
    private void initialize() {
        paneWithControls.setVisible(false); //hide content
        menuItem.setOnAction(new EventHandler<ActionEvent>() { //implementing action listener
            @Override
            public void handle(ActionEvent event) {
                text.setText("Some text you want to display"); //set value for controls
                paneWithControls.setVisible(true); //display content
            }
        });
    }

}