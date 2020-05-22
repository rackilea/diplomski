rule "who knits"
when
  $person: Person( $name: name )
  Hobby(name == "Knitting") from $person.hobbies
then
  System.out.println( "Knitting: " + $name );
end

public class Person {
  private String name;
  private List<Hobby> hobbies = new ArrayList<Hobby>();
  public String getName(){
    return name;
  }  
  public Iterable<Hobby> getHobbies(){
     return hobbies;
  }
}