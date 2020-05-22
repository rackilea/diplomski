public class Employee {
    String name;
    int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("Employee{name=%s, age=%d}", name, age);
    }
}