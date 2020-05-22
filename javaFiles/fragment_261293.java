import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;

public class Test {

    static class Person {
        public final String name;
        public Person(String name) {
            this.name = name;
        }
    }

    public static Collection<Person> peopleFromNames(Collection<String> names) {
        return Collections2.transform(names, new Function<String, Person>() {
            public Person apply(String name) {
                return new Person(name);
            }});
    }

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Brian", "Albert", "Roger");
        for (Person person : peopleFromNames(names)) {
            System.out.println(person.name);
        }
    }

}