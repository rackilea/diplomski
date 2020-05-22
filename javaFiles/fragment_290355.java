@Override
public void initialize(URL location, ResourceBundle resources) {

    button2.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            lbColor.setStyle("-fx-background-color:"+ getColorString()+";");
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
                        setStyle("-fx-background-color: "+ getColorString () +"; ");
                    }
                }
            };
        }
    };
    datePicker.setDayCellFactory(set);
}