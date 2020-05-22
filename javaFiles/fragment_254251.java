public class Couple
{
    private Person ying;
    private Person yang;

    public Couple(Person ying, Person yang)
    {
        this.ying = ying;
        this.yang = yang;
    }

    public Person getYing()
    {
        return ying;
    }

    public Person getYang()
    {
        return yang;
    }

    @Override
    public String toString()
    {
        return "Couple{" +
               "ying=" + ying +
               ", yang=" + yang +
               '}';
    }
}