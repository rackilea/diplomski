@ContextConfiguration(locations = {"classpath:mvc-dispatcher-servlet.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceImplTest {

@Autowired
UserService userService;

@Test
public void shouldAddUser() {
    User user = new User("firstName", "lastName", new Date(), "M", "username", "password");
    userService.addUser(user);
}
}