public class test {
  public static void main(String[] args) {
    List<Person> persons = new ArrayList<>(); // create a list to store the generated persons
    for (int i = 0; i < 20; i++) {
      Person person = new Person(); // generate a person
      person.setId(i);
      person.setAge(ThreadLocalRandom.current().nextInt(0, Person.MAX_AGE + 1));
      person.setGender((Math.random() < 0.5));
      person.setSexAppeal(ThreadLocalRandom.current().nextInt(0, Person.MAX_SEX_APPEAL + 1));
      person.setAgressionLevel(ThreadLocalRandom.current().nextInt(0, Person.MAX_SEX_APPEAL + 1));
      person.setStrength(ThreadLocalRandom.current().nextInt(0, Person.MAX_SEX_APPEAL + 1));
      person.setAlive(true);

      persons.add(person); /// add the generated person to the list

    }


  }
}