public final class Group { // Can't have a malicious subclass.
    public void deregisterPerson(Person.Standin standin) {
        Person person = standin.person();
        ...
    }
}
public class Person { // May be subclassed.
    public final class Standin { // Could be one per Person.
        private Standin() { // Hide constructor from other outer classes.
        }
        public Person person() {
            return Person.this;
        }
    }
    private void groupDeregister(Group group) {
        group.deregisterPerson(new Standin());
    }
 }