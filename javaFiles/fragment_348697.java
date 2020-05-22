@Entity
public class User_Name {
    private User_Name() {
    }

    public User_Name(String name) {
        this.name = name;
    }

    @Id public String name;
}