package work.basil.example;

import java.util.UUID;

public class Person
{
    // Static
   static public  String LOREM_IPSUM = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

    // Member variables.
    public String givenName, surname, description;
    public UUID id;

    public Person ( String givenName , String surname , UUID id , String description)
    {
        this.givenName = givenName;
        this.surname = surname;
        this.id = id;
        this.description = description ;
    }

    @Override
    public String toString ()
    {
        return "Person{ " +
                "givenName='" + givenName + '\'' +
                " | surname='" + surname + '\'' +
                " | id='" + id + '\'' +
                " }";
    }
}