import java.util.ArrayList;
import java.util.List;


public class Dating
{
    private List<Person> individuals = new ArrayList<Person>();
    private List<Couple> couples     = new ArrayList<Couple>();

    public static void main(String[] args)
    {
        Dating dating = new Dating();

        dating.addIndividual(new Person("Jack"));
        dating.addIndividual(new Person("Mike"));
        dating.addIndividual(new Person("Lydia", Gender.FEMALE));
        dating.addIndividual(new Person("Kate", Gender.FEMALE));

        System.out.println(dating);
    }

    public void addIndividual(Person p)
    {
        this.individuals.add(p);
    }

    public void removeIndividual(Person p)
    {
        this.individuals.remove(p);
    }

    public Person findIndividual(String name)
    {
        Person found = null;

        if (name != null)
        {
            for (Person p : this.individuals)
            {
                if (name.equals(p.getName()))
                {
                    found = p;
                    break;
                }
            }
        }

        return found;
    }

    @Override
    public String toString()
    {
        return "Dating{" +
               "individuals=" + individuals +
               ", couples=" + couples +
               '}';
    }
}