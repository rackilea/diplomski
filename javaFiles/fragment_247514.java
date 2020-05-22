private final ObservableList<RecordedTest> data = FXCollections.observableArrayList();
private final FilteredList<RecordedTest> filteredList = new FilteredList<>(data);

@Override
public void initialize(URL location, ResourceBundle resources) {

    initCellFactories();

    recordedTestService = UtilsForSpring.getSingleBeanOfType(IRecordedTestService.class);
    filteredList.setPredicate(null);
    data.setAll(recordedTestService.getThisMonthRecords());
    tblvRecords.setItems(filteredList);
    lblRecordSize.textProperty().bind(Bindings.size(filteredList).asString());
    ...
}

...

public void btnClearOnClickAction(ActionEvent e) {
    ...

    filteredList.setPredicate(null);
    data.setAll(recordedTestService.getThisMonthRecords()));
}