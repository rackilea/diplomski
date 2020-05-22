public class Person {
  private final String name;
  private final String surname;
  private final String day;
  private final String car;
  private final String city;
  private final String petName;

  public Person(final String name, final String surname, final String day, final String car, final String city, final String petName) {
    this.name = name;
    this.surname = surname;
    this.day = day;
    this.car = car;
    this.city = city;
    this.petName = petName;
  }

  public String getName() {
    return this.name;
  }

  public String getSurname() {
    return this.surname;
  }

  public String getDay() {
    return this.day;
  }

  public String getCar() {
    return this.car;
  }

  public String getCity() {
    return this.city;
  }

  public String getPetName() {
    return this.petName;
  }
}