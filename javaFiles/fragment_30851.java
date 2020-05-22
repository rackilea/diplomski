idColumn.setCellValueFactory(cellData -> 
    new SimpleStringProperty(cellData.getValue().getId()));
// or 
// idColumn.setCellValueFactory(new PropertyValueFactory<>("id")); 
// but the first version above is better, imho

nCaseColumn.setCellValueFactory(cellData -> 
    new SimpleStringProperty(cellData.getValue().getCase().getIdCase()));