public class Person
{
    private final String firstName;
    private final String lastName;
    private final String middleName; // guessing that is what mName is...
    private final String fathersName;
    private final String dateOfBirth;
    private final String placeOfBirth; // guessing that is what pOfBirth is...

    public Person(final String firstName,
                  final String lastName,
                  final String middleName,
                  final String fathersName,
                  final String dateOfBirth,
                  final String placeOfBirth)
    {
        if(firstName == null)
        {
            throw new IllegalArgumentException("firstName cannot be null");
        }

        if(lastName == null)
        {
            throw new IllegalArgumentException("lastName cannot be null");
        }

        ... etc for all of the other arguments ...

        // I would never do the this.fristName thing.. .I would name the parameter different than the instance vairable...
        this.firstName = firstName;
        this.lastName  = lastName;

        ... etc for all of the other arguments ... 
    }

    public boolean equals(final Object o)
    {
        final Person person;

        if(!(o instanceof Person))
        {
            return (false);
        }

        other = (Person)o;

        // the code you I put above + your code for checking if they are equal
    }

    public int hashCode()
    {
        // this is probably good enough
        return (firstName.hashCode() + lastName.hashCode());
    }
}