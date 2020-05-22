@Entity
public class User_Email {
    private User_Email() {
    }

    public User_Email(String email) {
        this.email = email;
    }

    @Id public String email;
}