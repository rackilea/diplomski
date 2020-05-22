package work.basil.example;

public class Student
{
    // ---------|  Member Vars  |-------------------------

    private String name;
    private Boolean active;

    // ---------|  Constructors  |-------------------------

    public Student ( String name , Boolean active )
    {
        this.name = name;
        this.active = active;
    }

    // ---------|  Logic  |-------------------------

    public void activate ( )
    {
        this.active = Boolean.TRUE;
    }

    // ---------|  Object  |-------------------------

    @Override
    public String toString ( )
    {
        return "Student{ " +
                "name='" + name + '\'' +
                " | active=" + active +
                " }";
    }
}