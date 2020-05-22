import java.util.Comparator;
public class PersonFullNameComparator implements Comparator<Person> {
  // This is your singleton
  public static final PersonFullNameComparator INSTANCE = new PersonFullNameComparator(); 

  // This is, if you want to forbid creating other instances
  private PersonFullNameComparator() {}

  @Override
  public int compare(Person arg0, Person arg1) {
    return arg0.getFullName().compareTo(arg1.getFullName());
  }
}