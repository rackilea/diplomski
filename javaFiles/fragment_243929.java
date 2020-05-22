public class Person implements Comparable<Person> {
  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String name;
  public int age;

  @Override
  public int compareTo(Person other){
    return (age - other.age);
  }
}