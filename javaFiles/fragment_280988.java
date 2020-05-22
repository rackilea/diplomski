public static void main(String... args) {
    Person john = new Person("John Doe", Gender.MALE, MaritalStatus.MARRIED);
    Person jane = new Person("Jane Doe", Gender.FEMALE, MaritalStatus.MARRIED);
    Person joe  = new Person("Joe Bloe", Gender.MALE, MaritalStatus.SINGLE);

    Set<Person> husbands = Stream.of(john, jane, joe)
            .filter(person -> person.gender == Gender.MALE)
            .filter(person -> person.maritalStatus == MaritalStatus.MARRIED)
            .collect(Collectors.toSet());
}

enum Gender {  MALE, FEMALE  }
enum MaritalStatus { MARRIED, SINGLE }
static class Person {
    final String name;
    final Gender gender;
    final MaritalStatus maritalStatus;

    Person(String name, Gender gender, MaritalStatus maritalStatus){
        this.name = name;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
    }
}