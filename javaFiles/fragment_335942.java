import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class Test {
  public static void main(String args[]){
    List<Person> people = Arrays.asList(new Person("Bob",25,"Geneva"),new Person("Alice",27,"Paris"));
    List<String> listNames = people.stream().map(u -> u.getName()).collect(Collectors.toList());
    System.out.println(listNames);
  }
}
class Person
{
   private String name;
   private int age;
   private String location;

  public Person(String name, int age, String location){
    this.name = name;
    this.age = age;
    this.location = location;
  }

  public String getName(){
    return this.name;
  }

}