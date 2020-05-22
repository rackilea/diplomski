public class Person {

    public static void testComparator() {
        Person p1 = new Person("c");
        Person p2 = new Person("a");
        Person p3 = new Person("b");
        List<Person> persons = Arrays.asList(p1, p2, p3);
        Collections.sort(persons, PersonComparator.INSTANCE);
        System.out.println("After normal sorting: " + persons);
        Collections.sort(persons, Collections.reverseOrder(PersonComparator.INSTANCE));
        System.out.println("After reverse sorting: " + persons);
    }

    public Person(String name) { this.name = name; }

    public String name;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Person [name=").append(name).append("]");
        return builder.toString();
    }

}

class PersonComparator implements Comparator<Person> {

    public static final PersonComparator INSTANCE = new PersonComparator();

    @Override
    public int compare(Person o1, Person o2) {
        return o1.name.compareTo(o2.name);
    }

}