public class Normal
{
    public string firstName;
    public string lastName;

    public String getName()
    {
        return firstName + " " + lastName;
    }

    public  String setName(String newName)
    {
        //parse newName into a first and last name.
        ...
        firstName = newFirstName;
        lastName = newLastName;
        return getName();
    }
}