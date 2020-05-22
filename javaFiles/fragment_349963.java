public class User extends Person
{
    @Override
    String toString ()
    {
        return this.id + " " + this.email;
    }
}