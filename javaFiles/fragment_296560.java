public class PersonPresenter implements Initializable {    

    @FXML
    private Text myText;

    //Some how get the Person object reference
    Person person = getPerson();

    private void initialize() {
        myText.setText(person.getName());
    }
    ...
}