Person person1 = new Person("John", "Doe");
Person person2 = new Person("John", "Doe");
Person person3 = new Person("Mary", "Doe");
Person person4 = new Person("Mary", "Doe");
Person person5 = new Person("john", "Smith");
List<Person> persons = Arrays.asList(person1, person2, person3, person4, person5);

// Creates your own equality using "group by". Here we are using first and last name concatenation
final Map<String, List<Person>> collect = persons.stream()
        .collect(Collectors.groupingBy(o -> o.getFirstName() + o.getLastName()));
// Get the values and extract the first element to build a distinct list.
final List<Person> collect1 = collect.values().stream().map(ps -> ps.get(0)).collect(Collectors.toList());
System.out.println(collect1.size());