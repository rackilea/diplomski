@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private Date birthDate;
    private String email;
    private String profileImage;

    public User() {

    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;

    }

    // Getter and Setter methods

    @Column
    public getUsername() {
        return username;
    }

    @Column
    public getPassword() {
        return password;
    }

    @Column
    public getFirstname() {
        return firstname;
    }

    @Column
    public getLastname() {
        return lastname;
    }

    @Column
    @Temporal(TemporalType.TIME)
    public getBirthDate() {
        return birthDate;
    }

    @Column
    public getEmail() {
        return email;
    }

    @Column
    public getProfileImage() {
        return profileImage;
    }
}