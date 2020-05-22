public class Person {
    private String id;
    private String lName;
    private String fName;
    private String height;

    public Person(String id, String fName, String lName, String height) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.height = height;
    }

    public String toString() {
        return "Person[" + id + ": " + lName + ", " + fName + ", " + height + "]";
    }
}