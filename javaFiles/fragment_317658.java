import java.util.*;

public class Test {

    public static void main(String[] args) {
        List<Person> list = new ArrayList<Person>();
        list.add(new Person("alpha", "astreet", 12));
        list.add(new Person("bravo", "bstreet", 23));
        list.add(new Person("charlie", "cstreet", 34));
        list.add(new Person("delta", "dstreet", 45));

        System.out.println(String.format("%-10s%-10s%-10s", "Name", "Age", "Adress"));
        for (Person p : list)
            System.out.println(String.format("%-10s%-10s%-10d", p.name, p.addr, p.age));
    }
}

class Person {
    String name;
    String addr;
    int age;
    public Person(String name, String addr, int age) {
        this.name = name;
        this.addr = addr;
        this.age = age;
    }
}