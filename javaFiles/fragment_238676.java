public class MyPasswordEncoderTest {

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private MyPasswordEncoder myPasswordEncoder = new MyPasswordEncoder();

    @Before
    public void init() {
        ReflectionTestUtils.setField(myPasswordEncoder, "passwordEncoder", passwordEncoder);
    }

    @Test
    public void testPasswordMatching() {
        String plainTextPassword = "ABCdef123@@@";
        String encodedPassword = myPasswordEncoder.encode(plainTextPassword);
        assertTrue(myPasswordEncoder.matches(plainTextPassword, encodedPassword));
    }
}