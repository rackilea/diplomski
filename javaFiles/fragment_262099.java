public class InputController {
    @FXML
    private TextField mealField;
    private boolean mealChosen;

    @FXML
    private void submit() {
        mealChosen = true;
        mealField.getScene().getWindow().hide();
    }

    public String getMeal() {
        return mealChosen ? mealField.getText() : null;
    }

}