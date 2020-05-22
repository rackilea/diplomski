public void initialize(URL url, ResourceBundle rb) {
    assert tableview != null : "fx:id=\"tableview\" was not injected: check your FXML file 'UserMaster.fxml'.";
 colName.setCellValueFactory(
    new PropertyValueFactory<Person,String>("name"));        
colSurname.setCellValueFactory(                
    new PropertyValueFactory<Person,String>("surname"));
colCountry.setCellValueFactory(
    new PropertyValueFactory<Person,String>("country"));     

buildData();
tableview.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Person>() {
        @Override
        public void changed(ObservableValue<? extends Person> observable, Person oldValue, Person newValue) {
            if (oldValue !=null) name.textProperty().unbindBidirectional(oldValue.nameProperty());
            if (newValue !=null) name.textProperty().bindBidirectional(newValue.nameProperty());
        }
    });
}    //initialize