public class UserInfoController {

    @FXML
    private TextField name ;
    @FXML
    private ComboBox<String> department ;

    private final StringProperty nameProp = new SimpleStringProperty();
    private final ObjectProperty<String> departmentProp = new SimpleObjectProperty();

    public StringProperty nameProperty() {
        return nameProp;
    }

    public final String getName() {
        return nameProperty().get();
    }

    public final void setName(String name) {
        nameProperty().set(name);
    }

    public ObjectProperty<String> departmentProperty() {
        return departmentProp ;
    }

    public final String getDepartment() {
        return departmentProperty().get();
    }

    public final void setDepartment(String department) {
        departmentProperty().set(department);
    }

    public void initialize() {
        // initialize controls with data currently in properties, 
        // and ensure changes to controls are written back to properties:
        name.textProperty().bindBidirectional(nameProp);
        department.valueProperty().bindBidirectional(departmentProp);
    }
}