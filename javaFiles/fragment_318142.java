public class Enemy
{
    private String name;

    public Enemy(String name)
    {
        this.name = name;
    }
    public getName()
    {
        return name;
    }
}

Enemy orc = new Enemy("orc"); // could be an array of references instead of a var
orc.getName(); // returns the name of the object, obviously the name is whatever you construct the object with; so you could use any object identifier you like (such as a hash), this also means you can just construct the object and store its reference in an array