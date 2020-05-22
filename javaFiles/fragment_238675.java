@ContextConfiguration(classes = {MyPasswordEncoder.class, MyPasswordEncoderConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class MyPasswordEncoderTest {

        @Autowired
        private PasswordEncoder passwordEncoder;

        @Autowired
        private MyPasswordEncoder myPasswordEncoder;

        @Test
        public void testPasswordMatching() {
            String plainTextPassword = "ABCdef123@@@";
            String encodedPassword = myPasswordEncoder.encode(plainTextPassword);
            assertTrue(myPasswordEncoder.matches(plainTextPassword, encodedPassword));
        }
    }