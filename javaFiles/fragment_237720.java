public class MyUserDetails implements UserDetails {
    private String username;
    private String password;

    private String firstname;
    private String lastname;

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    // Etc.
}