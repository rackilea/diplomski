import java.util.List;
// This is the user object
public class User {

    public String id;
    public String name;
    public String surname;
    public String email;
    public String password;
    public String subject;
    public List<String> literature;

    public User(String id, String name, String surname, String email, String password,
            String subject, List<String> literature) {

        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.subject = subject;
        this.literature = literature;
    }
}