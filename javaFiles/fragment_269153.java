private final ObservableList<DataHandler_ExamsListing> EListingData = FXCollections.observableArrayList();
private final FilteredList<DataHandler_ExamsListing> FilteredData = new FilteredList<>(EListingData);
private final SortedList<DataHandler_ExamsListing> sortedData = new SortedList<>(FilteredData);

@FXML
private void initialize() {
    EListingTable.setItems(sortedData);
}

private void LoadEListingData(){
    List<DataHandler_ExamsListing> data = new ArrayList<>();
    try {
        // prepare data for insert using single update
        DBE.resultSet = DBE.statement.executeQuery("SELECT * FROM Exam"); // directly accessing static fields of a different class is a terrible idea since it violates the information hiding principle
        while (DBE.resultSet.next()) {                
            data.add(new DataHandler_ExamsListing(DBE.resultSet.getInt("ExamID"),DBE.resultSet.getString("ExamName"),DBE.resultSet.getString("ExamDate"),DBE.resultSet.getString("ExamComment")));
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Never just ignore an exception unless it's expected
        return;
    }
    // update data
    EListingData.setAll(data);
}