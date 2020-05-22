enum Gender {

    Male, Female;
}

public class Person {

    private final String name;
    private final Gender gender;
    private final int age;

    public Person(String naam, Gender gender, int age) {
        this.name = naam;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public int getAgeDifference(final Person other) {
        return age - other.age;
    }

    @Override
    public String toString() {
        return String.format("%-9s - %s - %2d", name, gender, age);
    }
}

public void test() {
    final List<Person> personen = Personen.getPersonen();

    Map<String, Person> map
            = personen.stream().collect(Collectors.toMap(p -> p.getName() + "-" + p.getAge(), p -> p));
    for (String s : map.keySet()) {
        System.out.printf("%-15s -> %s\n", s, map.get(s));
    }
    Map<Integer, List<Person>> peopleByAge = personen
            .stream()
            .collect(Collectors.groupingBy(Person::getAge)); //THIS METHOD

    peopleByAge.forEach((k, v) -> System.out.printf("%2d: %s\n", k, v));

    Map<Integer, List<String>> peoplesNamesByAge = personen
            .stream()
            .collect(
                    Collectors.groupingBy(Person::getAge,
                            Collectors.mapping(Person::getName,
                                    Collectors.toList())));
    peoplesNamesByAge.forEach((k, v) -> System.out.printf("%2d: %s\n", k, v));

    System.out.println();

    // TreeMap<Integer, Long> perLeeftijd
    Map<Integer, Long> perLeeftijd = personen
            .stream()
            .collect(Collectors.groupingBy(Person::getAge, Collectors.counting()));

    perLeeftijd.forEach((k, v) -> System.out.printf("%2d -> %d\n", k, v));
}