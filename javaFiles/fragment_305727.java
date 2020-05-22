public class Main extends Application {

  SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
  private Date dateUtil = sdf.parse("2016/09/25");

  public Main() throws ParseException {
  }

  @Override public void start(Stage primaryStage) throws Exception {
    Button button = new Button("Take date from DatePicker");
    Label labelCompare = new Label();
    Label labelCompare2 = new Label();
    DatePicker datePicker = new DatePicker();

    //convert Date to LocalDate
    LocalDate localDate = dateUtil.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    //set in DatePicker
    datePicker.setValue(localDate);

    VBox hBox = new VBox();
    hBox.getChildren().addAll(datePicker, button, labelCompare, labelCompare2);
    Scene scene = new Scene(hBox, 400, 400);
    primaryStage.setScene(scene);
    primaryStage.show();

    button.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent e) {
        //Take LocalDate from DatePicker
        LocalDate localDate = datePicker.getValue();

        //Convert LocalDate to Date
        Date dateFromPicker = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

        //compare
        labelCompare.setText("Compare date: " + dateUtil.compareTo(dateFromPicker));
      }
    });
  }

  public static void main(String[] args) {
    launch();
  }
}