@FXML
private JFXComboBox<Departamento> cbDepart;
private ObservableList<Departamento> obsDepartamentos;
public void initialize(URL url, ResourceBundle rb) {
    DepartamentoDAO dao = new DepartamentoDAO();
    obsDepartamentos = FXCollections.observableArrayList();
    for(Departamento d: dao.read()){
       obsDepartamentos.add(d);
    }
    cbDepart.setItems(obsDepartamentos);
}