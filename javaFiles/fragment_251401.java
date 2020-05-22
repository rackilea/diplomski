public abstract class Person {
    protected List<Person> friends = new ArrayList<>();
    public void callCellPhone() { ... }
}

public class Student extends Person {
    public void callFriends() {
        // friends is defined in the super-class
        // "super" is an optional qualifier here
        for (Person person : super.friends) {
            person.callCellPhone();
        }
    }
}