public class Person {

  // fields
  private String person = "";
  private int age = 0;
  private String city = "";
  private int sibCount = 0;

  // constructor
  public Person() {
  }

  // public access methods (getters)
  public String getPerson() {
    return this.person;
  }

  public int getAge() {
    return this.age;
  }

  public String getCity() {
    return this.city;
  }

  public int getSibCount() {
    return this.sibCount;
  }

  // toString
  public String toString() {
    return "person: " + person + ", age: " + age + ", city: " + city;

  // factory method
  public static Person parseCommaDelim(String s) {
    String[] tokens = s.split(",");

    Person instance = new Person();
    instance.person = tokens[0];
    instance.age = Integer.parseInt(tokens[1];
    instance.city = tokens[2];
    // ...

    return instance;
  }
}