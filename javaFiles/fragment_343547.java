FXMLLoader loader = new FXMLLoader();
loader.setLocation(getClass().getResource("sample.fxml"));
borderPane = new BorderPane();

// load a new UI from the FXML file:
borderPane = loader.load();
// get the controller for the new UI:
Controller controller = loader.getController();
ObservableList<radnici> lista = FXCollections.observableArrayList();
lista.add(new radnici(upišiRadnika.getText()));
// set the table items in the new UI:
controller.tabela.setItems(lista);
upišiRadnika.clear();
controller.CloseStage();