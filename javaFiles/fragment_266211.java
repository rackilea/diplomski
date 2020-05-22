public class SavePersonCommand {
    private Person person;

    public SavePersonCommand(Person person) {
       this.person = person;
    }

    public Person getPerson() {
       return this.person;
    }
}