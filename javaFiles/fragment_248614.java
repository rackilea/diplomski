@Override
public void initialize​(URL location, ResourceBundle resources) {
    final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE", Locale.GERMAN);

    for (int i = 1; i <= lastDay; i++) {
        final int dayIndex = i-1;
        DayOfWeek day = DayOfWeek.of(i);
        TableColumn<Auftragsverteilung[], Integer> column = new TableColumn<>(formatter.format(day));
        column.setCellValueFactory(cd -> {
            Auftragsverteilung auftrag = cd.getValue()[dayIndex];
            return new SimpleObjectProperty<>(auftrag == null ? null : auftrag.getSeriennr());
        });
        tableRechnerWoche.getColumns().add(column);

    }

    tableRechnerWoche.setItems(rechnerWochenansichtTabelle);
    ...
}