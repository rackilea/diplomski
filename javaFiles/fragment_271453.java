public class Base {
  private final String lastName;

  public Base(String lastName) { this.lastName = lastName; }
  public String getLastName() {
    return lastName;
  }
}

public class Child extends Base {
  private String firstName;

  public Child(String lastName, String firstName) { 
    super(lastName);
    this.firstName = firstName; 
  }
  public String getFirstName() {
    return firstName;
  }
}