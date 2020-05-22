//Opening new Stage on button clicked
public void dodajRadnikaDugemKlik() throws IOException {
    FXMLLoader loader = new FXMLLoader();
    borderPane = new BorderPane();
    loader.setLocation(getClass().getResource("dodajRadnika.fxml"));
    borderPane = loader.load();

    DodajRadnikaKontroler controller = loader.getController();
    controller.setItems(tabela.getItems());

    scene = new Scene(borderPane);
    stage.setTitle("Dodaj Radnika");
    stage.setScene(scene);
    stage.showAndWait();
}