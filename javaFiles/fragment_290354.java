public class Controller implements Initializable {

    //defines the incremental change in color 
    private static final int COLOR_INCREMENT = 30;
    //initial rgb values (green) 
    private int red = 0, green = 255, blue = 0;
    @FXML
    private Button button2;

    @FXML
    private DatePicker datePicker;

    @FXML
    private Label lbColor;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                lbColor.setStyle("-fx-background-color:"+ getColorString()+";");
            }

        });
        //Cell factory omitted. Not needed to demonstrate the question nor the answer 
    }

    //increment color by COLOR_INCREMENT to step from green to yellow to red 
    //and return string representation of it 
    //green is rgb is (0, 255, 0)
    //yellow rgb is (255, 255, 0)
    //red in rgb is (255, 0, 0)
    private String getColorString() {

        if((green == 255) && (red < 255)) {
            red = (red + COLOR_INCREMENT) > 255 ?  255 : (red + COLOR_INCREMENT) ;
        }else if( (red == 255) && (green > 0)){
            green = (green - COLOR_INCREMENT) < 0 ?  0 : (green - COLOR_INCREMENT) ;
        }

        StringBuilder sb = new StringBuilder("rgb(");
        sb.append(red).append(",")
        .append(green).append(",")
        .append(blue).append(")");

        return sb.toString();
    }
}