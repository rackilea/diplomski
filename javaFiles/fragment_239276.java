@FXML
TableView<Client> selectClientTable;
@FXML
TableColumn<Client, String> CodeC, NomC, RegCommerceC, IdFiscalC, NArtFisC;
@FXML
Button selectClientButton, returnSelectClientButton;

ObservableList<Clients> mylist = FXCollections.observableArrayList();

@Override
public void initialize(URL location, ResourceBundle resources) {
    populateTable();
}


void populateTable() {
    mylist.addAll(clientsArray);

    CodeC.setCellValueFactory(c -> new SimpleStringProperty(String.valueOf(c.getValue().getCodeC())));
    NomC.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getNomC()));
    RegCommerceC.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getRegCom()));
    IdFiscalC.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getIdFiscal()));
    NArtFisC.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getnArticleFiscal()));

    for (Clients client : clientsArray) {
        System.out.println(String.valueOf(client.getCodeC()) + client.getNomC() + client.getRegCom() + client.getIdFiscal() + client.getnArticleFiscal());
    }

    selectClientTable.setItems(mylist);
}