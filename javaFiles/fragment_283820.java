public class PersonComparator implements Comparator<Person>
{
    private Person.Type type;
    private float weight;
    public PersonComparator(Person.Type type, float weight) {
       this.type = type;
       this.weight = weight;
    }
}