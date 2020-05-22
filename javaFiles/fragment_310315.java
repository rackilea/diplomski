import java.util.ArrayList;
import java.util.List;

final class Person {

    private final String name;
    private final int age;

    public Person(final String name, final int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
}


public final class Main {

    public static void main(final String[] args) {
        final List<Person> persons = new ArrayList<>();  // <--- here ---
        persons.add(new Person("Name1", 1));
        persons.add(new Person("Name2", 2));
        persons.add(new Person("Name3", 3));
        persons
            .stream()
            .forEach(e -> System.out.println(e.getName()));
    }
}