public class Person {
  private final int age;

 /**
   * Creates a person with the specified age.
   *
   * @param age the age
   * @throws IllegalArgumentException if the age is not greater than zero
   */
  public Person(int age) {
    this.age = age;
    if (age <= 0) {
      throw new IllegalArgumentException("Invalid age:" + age);
    }
  }
}