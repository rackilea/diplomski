import static java.util.Arrays.asList;
import java.util.function.Supplier;
...
static class Person {
    String name;
    Person(String name) {
        this.name = name;
    }
    public String name() {
        System.out.println("name() called for = " + name);
        return name;
    }
}

public static <T> T coalesce(Supplier<T>... ts) {
    System.out.println("called coalesce(Supplier<T>... ts)");
    return asList(ts)
            .stream()
            .map(t -> t.get())
            .filter(t -> t != null)
            .findFirst()
            .orElse(null);
}

public static <T> T coalesce(T... ts) {
    System.out.println("called coalesce(T... ts)");
    for (T t : ts) {
        if (t != null) {
            return t;
        }
    }
    return null;
}

public static void main(String[] args) {
    Person nobody = new Person(null);
    Person john = new Person("John");
    Person jane = new Person("Jane");
    Person eve = new Person("Eve");
    System.out.println("result Stream API: " 
            + coalesce(nobody::name, john::name, jane::name, eve::name));
    System.out.println();
    System.out.println("result vargas    : " 
            + coalesce(nobody.name(), john.name(), jane.name(), eve.name()));
}