public class Foo {
  private List<Person> people;

  public Foo() {
    this.people = new ArrayList<Person>();
  }
  public void addItem(Person newMember) {
    people.add(newMember);
  }
}