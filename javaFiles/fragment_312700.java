public class Group { // Can have malicious subclasses.
    public void deregisterPerson(Person.GroupDeregister deregister) {
        if (deregister.group() != this) { // Not equals...
            throw new IllegalArgumentException();
        }
        Person person = deregister.person();
        ...
    }
}
public class Person { // May be subclassed.
    public final class GroupDeregister {
        private final Group group;
        private GroupDeregister(Group group) { // Hidden.
            this.group = group;
        }
        public Person person() {
            return Person.this;
        }
        public Group group() {
            return group;
        }
    }
    private void groupDeregister(Group group) {
        group.deregisterPerson(new GroupDeregister(group));
    }
 }