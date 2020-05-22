public class Employee implements Comparable {

    @Override
    public int compareTo(Object o) {
        Employee e = (Employee)o;
        return name.compareTo(e.getName());
    }

    // ...
}