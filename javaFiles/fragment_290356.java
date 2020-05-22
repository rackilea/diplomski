public class Controller implements Initializable {

    protected static final int COLOR_INCREMENT = 30;

    @FXML
    private Button button2;

    @FXML
    private DatePicker datePicker;

    @FXML
    private Label lbColor;

    private int red = 0, green = 255, blue = 0;
    private String colorAsString; //string representation of rgb color 
    private int clicksCounter = 0;
    private String date = String.valueOf(LocalDate.now().getDayOfMonth());

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                colorAsString = getColorString();
                lbColor.setStyle("-fx-background-color:"+ colorAsString +";");
            }
        });

        javafx.util.Callback<DatePicker, DateCell> set = new javafx.util.Callback<DatePicker, DateCell>() {
            @Override
            public DateCell call(final DatePicker datePicker) {
                return new DateCell() {
                    @Override public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);
                        //if today, change text and style
                        if (item.equals(LocalDate.now())) {
                            setText(date +"/" + clicksCounter);
                            setStyle("-fx-background-color: "+ colorAsString +"; ");
                        }
                    }
                };
            }
        };
        datePicker.setDayCellFactory(set);
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