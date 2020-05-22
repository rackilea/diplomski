public class SampleDialog extends FXMLStage {
     @FXML
     private AnchorPane dialog;
     @FXML
     private Label lb_size; 
     //....
     //some additional fields to initialize... 
     private final Session session; 
     public  SampleDialog(Session session, int size) {
        super("/fxml/SampleDialog.fxml");
        //initialize aditional fields:
        this.session=session;
        lb_size.setText("" + size);
    }
}