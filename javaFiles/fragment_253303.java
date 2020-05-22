@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration(locations = { "classpath:META-INF/your-spring-context.xml" })
public class UserServiceTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    private UserService userService;

    @Test
    public void testName() throws Exception {
        List<UserEntity> userEntities = userService.getAllUsers();

        Assert.assertNotNull(userEntities);
    }
}