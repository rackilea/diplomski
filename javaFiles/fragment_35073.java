private void createTableColumnsForTasks(ClassTestEvaluation cte) {
    int resultCounter = 1;

    // For each given task in ClassTestEvaluation...
    for (Task t : cte.getTasks()) {

        // ...create a column for the corresponding points reached (0 in the beginning).
        TableColumn<ClassTestEvaluationRow, Double> colResult = new TableColumn<>("A" + resultCounter + " (" + t.getPoints() + ")");
        resultCounter++;

        // Make the column editable.
        colResult.setEditable(true);


        // Define how the values in the task columns will be set.
        colResult.setCellValueFactory((TableColumn.CellDataFeatures<ClassTestEvaluationRow, Double> row) -> {

            ClassTestEvaluationRow cter = row.getValue();

            for(Result r : cter.getResults()) {
                if(r.getIdTask() == t.getId()) {
                    ObservableValue<Double> obsResult = new SimpleObjectProperty<Double>(r.getPoints());
                    return obsResult;               
                }
            }

            return null;

        });



        // Create combo box to choose points from for each given task and result.
        createTableColumnComboBoxForResultEditing(colResult, t);


        // Create method to store edited data in selected ClassTestEvaluationRow.
        createOnEditCommitMethods(colResult, t);

        ((EvaluatorUI) this.getView()).getTableView().getColumns().add(colResult);

    }

}



private void createTableColumnComboBoxForResultEditing(TableColumn<ClassTestEvaluationRow, Double> colResult, Task t) {
    ArrayList<Double> cbPoints = new ArrayList<>();

    for(double i = 0.0; i <= t.getPoints(); i = i+0.5) {
        cbPoints.add(i);
    }

    ObservableList<Double> obsPoints = FXCollections.observableArrayList(cbPoints);

    colResult.setCellFactory(ComboBoxTableCell.<ClassTestEvaluationRow, Double>forTableColumn(obsPoints));      
}




private void createOnEditCommitMethods(TableColumn<ClassTestEvaluationRow, Double> colResult, Task t) {

    colResult.setOnEditCommit((CellEditEvent<ClassTestEvaluationRow, Double> event) -> {
        TablePosition<ClassTestEvaluationRow, Double> pos = event.getTablePosition();
        Double newValue = event.getNewValue();
        int row = pos.getRow();
        ClassTestEvaluationRow cter = (ClassTestEvaluationRow) event.getTableView().getItems().get(row);

        for(Result result : cter.getResults()) {
            if(result.getIdTask() == t.getId()){
                result.setPoints(newValue);
                classTestEvaluationsService.updateResult(cter.getClassTestEvaluation(), result);
            }
        }

    });

}