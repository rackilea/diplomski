@FXML
private TableColumn<AppointmentDTO, String> patientNameColumn ;

// ...

public void initialize() {

    // ...

    patientNameColumn.setCellValueFactory(cellData -> 
        new SimpleStringProperty(cellData.getValue().getPatientDTO().getPatientName()));

    // ...
}