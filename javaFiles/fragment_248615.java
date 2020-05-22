@FXML
private TableView<Auftragsverteilung[]> tableRechnerWoche;
@FXML
private TableColumn<Auftragsverteilung[], Integer> col_RW_Montag;
@FXML
private TableColumn<Auftragsverteilung[], Integer> col_RW_Dienstag;
@FXML
private TableColumn<Auftragsverteilung[], Integer> col_RW_Mittwoch;
@FXML
private TableColumn<Auftragsverteilung[], Integer> col_RW_Donnerstag;
@FXML
private TableColumn<Auftragsverteilung[], Integer> col_RW_Freitag;

...

public void wochenansichtFuellen() {

    // ComboBox Listener (ChangeListener)
    comboBox_RW_Wochenansicht.valueProperty().addListener((o, oldValue, newValue) -> {
        rechnerWochenansichtTabelle.clear();

        // String split, first date = monday, last date = friday
        String startdatum = newValue.substring(0, 10);
        String enddatum = newValue.substring(11, 21);

        // db = Database object with method getTasksFromWeek
        try {
            // depending on the return type and order of the elements
            // rechnerWochenansichtTabelle.add(db.getRechnerAusAuftragsverteilungWoche(startdatum, enddatum));
            // may be sufficient instead of the following code

            // store each Auftragsverteilung in array with index corresponding to the day of week of the bearbeitungsdatum
            Auftragsverteilung[] row = new Auftragsverteilung[DayOfWeek.FRIDAY.getValue()];
            for (Auftragsverteilung auftrag : db.getRechnerAusAuftragsverteilungWoche(startdatum, enddatum)) {
                LocalDate date = auftrag.getBearbeitungsdatum().toLocalDate();
                row[date.getDayOfWeek().getValue() - 1] = auftrag;
            }

            rechnerWochenansichtTabelle.add(row);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    });

}