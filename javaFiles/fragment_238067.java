@FXML
public void seleccionar() throws IOException {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("/vistas/RegistrarCita.fxml")) ;
    Parent root = loader.load();
    RegistrarCitaControladora rcc = loader.getController();

    // ...
}