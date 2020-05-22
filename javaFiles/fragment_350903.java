public class PersonUi
{
    private Guid personId; // Or UUID for java
    private IPersonService personService;

    ...

    nameTextBox.text = personService.getPersonName(personId);
}