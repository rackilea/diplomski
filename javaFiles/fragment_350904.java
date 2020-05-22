public class PersonUi implements IPersonNameChangeListener
{
    private Guid personId; // Or UUID for java
    private IPersonService personService;

    ...

    public void userEnteredANewNameThroughUI(String newName)
    {
        personService.setName(personId, newName);
    }

    @Override
    public void onPersonNameChange(Guid personId, String newName)
    {
        if(this.personId != personId)
             return;

        nameTextBox.text = newName;
    }
}