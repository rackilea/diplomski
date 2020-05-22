public class Person {
  public final String firstName;
  public final String lastName;
  public final String birthDate; //should really be a java.util.Date
  //...plus a constructor for the above
}

//...
List<Person> people = new ArrayList<Person>();
String line = reader.readLine();
String[] fields = line.split(", ");
people.add(new Person(fields[0], fields[1], /*...*/));