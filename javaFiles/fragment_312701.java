public class Person { // "PrivatePerson"
    public PublicPerson publicPerson() {
         return new PublicPerson(this);
    }
    private void groupRegister(Group group) {
        group.registerPerson(this);
    }
    private void groupDeregister(Group group) {
        group.deregisterPerson(this);
    }
    ...
}
public class PublicPerson {
    private final Person person;
    public PublicPerson(Person person) {
        this.person = person;
    }
    @Override public final boolean equals(Object obj) {
        return obj instanceof Person && (Person)obj.person == person;
    }
    @Override public final int hashCode() {
        return person.hashCode();
    }
    ...methods, but no raw registration...
 }
 public class Group {
     private final Set<Person> members = new IdentityHashSet<>(); // No Object.equals.
     public void registerPerson(Person person) {
         members.add(person);
     }
     public void deregisterPerson(Person person) {
         members.remove(person);
     }
     public Set<PublicPerson> members() {
         // This will be more concise in Java SE 8.
         Set<PublicPerson> publics = new HashSet<>();
         for (Member member : members) {
             publics.add(member.publicPerson());
         }
         return unmodifiableSet(publics);
     }
}