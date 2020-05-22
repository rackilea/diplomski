public class UserInfoController {

    private final UserInfo userInfo ;

    @FXML
    private TextField name ;
    @FXML
    private ComboBox<String> department ;

    public UserInfoController(UserInfo userInfo) {
        this.userInfo = userInfo ;
    }

    public void initialize() {
        name.textProperty().bindBidirectional(userInfo.nameProperty());
        department.valueProperty().bindBidirectional(userInfo.departmentProperty());
    }
}