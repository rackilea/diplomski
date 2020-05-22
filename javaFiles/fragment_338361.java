@Named
@SessionScoped
public class PersonController {

    @Inject
    private PersonService personService;

    private Person selectedPerson;

    /**
     * Method for updating.
     */
    public void updatePerson(ActionEvent actionEvent){
        Person updatedPerson = personService.update(selectedUser);
        // pass updatedPerson to presentation layer..
    }
}