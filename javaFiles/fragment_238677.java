@Component
public class MyPasswordEncoder {

    private final PasswordEncoder passwordEncoder; // Defined in Spring Security.

    @Autowired
    public MyPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public String encode(String plainTextPassword) {
        return passwordEncoder.encode(plainTextPassword);
    }

    public boolean matches(String encodedPasswordA, String encodedPasswordB) {
        return passwordEncoder.matches(encodedPasswordA, encodedPasswordB);
    }

}