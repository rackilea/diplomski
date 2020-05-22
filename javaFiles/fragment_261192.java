// create the lists:
ObservableList<Exercise> exercises = FXCollections.observableArrayList();

// initialize the filtered list with a filter that is always true 
// (i.e. no filtering)
ObservableList<Exercise> filteredExercises = exercises.filtered(exercise -> true);

// use the filtered list as the items list for the table:
public void initialize() {
    // ...

    exTable.setItems(filteredExercises);

    // ...
}

// filter by setting the predicate on the filtered list:
@FXML
private void filterByChest(ActionEvent event) {
    filteredExercises.setPredicate(
        exercise -> exercise.getFocusGroup().toLowerCase().contains("chest"));
}

// manipulate the list by adding/removing elements to/from the underlying list:
@FXML
private void deleteExercise(ActionEvent event) {
    Exercise selectedItem = exTable.getSelectionModel().getSelectedItem();
    exercises.remove(selectedItem);
}