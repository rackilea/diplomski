@RunWith(MockitoJUnitRunner.class)
public class LoginAttemptTest {
    @Mock
    LoginAttempt loginAttempt;

    @Test
    public void testObjectExistence() {
        System.out.println("loginAttempt="+loginAttempt);
    }
}