public class Person {
    private String name;
    private int age;

    public static Comparator COMPARE_BY_NAME = new Comparator<Person>() {
        public int compare(Person one, Person other) {
            return one.name.compareTo(other.name);
        }
    }

    public static Comparator COMPARE_BY_AGE = new Comparator<Person>() {
        public int compare(Person one, Person other) {
            return one.age > other.age ? 1
                 : one.age < other.age ? -1
                 : 0; // Maybe compare by name here? I.e. if same age, then order by name instead.
        }
    }

    // Add/generate getters/setters/equals()/hashCode()/toString()
}