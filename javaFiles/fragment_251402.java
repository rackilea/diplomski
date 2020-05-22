public class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static Collection<Person> parse(String input) {
        Collection<Person> persons = new HashSet<Person>();
        for (String s : input.split(";")) {
            String[] properties = s.split("\\|");
            persons.add(new Person(properties[0], Integer.parseInt(properties[1])));
        }
        return persons;
    }

    public static void main(String[] args) {
        String testString = "John|23;Ron|22;Don|32";
        System.out.println(parse(testString));

    }

}