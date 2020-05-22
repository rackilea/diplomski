public class MyPasswordEncoderTest {

    private MyPasswordEncoder myPasswordEncoder = new MyPasswordEncoder(new BCryptPasswordEncoder());

    @Test
    public void testPasswordMatching() {
        String plainTextPassword = "ABCdef123@@@";
        String encodedPassword = myPasswordEncoder.encode(plainTextPassword);
        assertTrue(myPasswordEncoder.matches(plainTextPassword, encodedPassword));
    }
}