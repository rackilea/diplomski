private void setTable(){
    columnaID.setCellValueFactory(
    new PropertyValueFactory<> ("id"));

    columnaNOMBRE.setCellValueFactory(
    new PropertyValueFactory<> ("nombre"));

    columnaCORREO.setCellValueFactory(
    new PropertyValueFactory<> ("correo"));

    columnaDIRECCION.setCellFactory(
    new PropertyValueFactory<> ("direccion"));

    columnaTELEFONO.setCellFactory(
    new PropertyValueFactory<> ("telefono"));

    tablaCLIENTES.setItems(data);
}