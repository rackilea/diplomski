public class StagingUser
{
    private String hi;
    private String name;
    private String lastName;

    public StagingUser()
    {

    }

    public String getHi ( )
    {
        return hi;
    }

    public void setHi ( String hi )
    {
        this.hi = hi;
    }

    public String getName ( )
    {
        return name;
    }

    public void setName ( String name )
    {
        this.name = name;
    }

    public String getLastName ( )
    {
        return lastName;
    }

    public void setLastName ( String lastName )
    {
        this.lastName = lastName;
    }


    @Override
    public String toString ( )
    {
        return "StagingUser [hi=" + hi + ", name=" + name + ", lastName=" + lastName + "]";
    }


}