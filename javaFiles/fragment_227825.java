public class CartonController implements Initializable {

@FXML
private ImageView imageView1 ;

@FXML
private ImageView imageView2 ;

@FXML
private ImageView imageView3 ;

@FXML
private ImageView imageView4 ;    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imageView1.setImage(new Image(...));
        // etc...
    }    

}