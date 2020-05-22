@Component
public class School {

    private Person jacobs;

    public School(@Qualifier("jacobs") Person jacobs) {
        this.jacobs = jacobs;
    }

    public String personName() {
        return jacobs.getName();
    }
}