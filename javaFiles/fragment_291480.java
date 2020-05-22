private void populateTable() {
    for (TableColumn tc : columns) {
        // need to figure out how to remove rowNumber from this....
        tc.setCellValueFactory(new ValueFactory(columns.indexOf(tc), rowNumber));
        dpcontroller.tableView.getColumns().add(tc);
    }
    //data included in dataRows are correct.//after printout debug


    dpcontroller.tableView.setItems(dataRows);//ERROR THROWN  IF MULTIPLE ROWS

}