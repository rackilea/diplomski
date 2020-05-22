public class SecondController implements Supplier<Optional<Person>> {
    @FXML
    private TextField givenName;
    @FXML
    private TextField familyName;

    private boolean submitted = false;

    // handler for submit action
    @FXML
    private void submit() {
        submitted = true;
        givenName.getScene().getWindow().hide();
    }

    // handler for cancel action
    @FXML
    private void cancel() {
        givenName.getScene().getWindow().hide();
    }

    @Override
    public Optional<Person> get() {
        return submitted ? Optional.of(new Person(givenName.getText(), familyName.getText())) : Optional.empty();
    }

}