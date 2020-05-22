public void initialize(URL url, ResourceBundle rb) { 
    unitcol.setCellValueFactory(new PropertyValueFactory<Person,String>("UnitName"));
    valuecol.setCellValueFactory(new PropertyValueFactory<Person,String>("Value"));
    typecol.setCellValueFactory(new PropertyValueFactory<Person,String>("Type"));
    nccol.setCellValueFactory(new PropertyValueFactory<Person,String>("NC")); 
}