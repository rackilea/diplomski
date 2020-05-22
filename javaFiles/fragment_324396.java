public class Person {

    private int id;
    private String name;
    private String surname;

    public Person() {}

    public Person(int i, String n, String s) {
        id = i;
        name = n;
        surname = s;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getSurname() {
        return this.surname;
    }
}