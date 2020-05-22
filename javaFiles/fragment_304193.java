private String[] classesList = null;

//overloaded constructor
public Student(String theFirstName, String theLastName, int theClasses)
{
    firstName = theFirstName;
    lastName = theLastName;
    classes = theClasses;

    classesList = new String[classes]; // THIS

    System.out.println("Number of Classes: " + classes);
}