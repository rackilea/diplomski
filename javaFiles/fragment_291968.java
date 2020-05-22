public class User extends Model
{
    public String name, surname;
    public int ID;
    public static int lastID;
    public static String usedIDs;

    public User(String name, String surname) //regular User objects
    {
        this.name = name;
        this.surname = surname;
        ID = ++lastID;
        usedID's += ID + " ";
    }

    public User(String name, String surname, int n) //first User object created
    {
        this.name = name;
        this.surname = surname;
        ID = 1;
        lastID = 1;
        usedID's = ID + " ";
    }

//rest of your methods