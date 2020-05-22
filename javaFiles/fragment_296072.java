public class Person {
    private String name;
    private String sex;

    public Person(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public Person(String name) {
        this(name, "male");
    }

    // getters/setters here
}