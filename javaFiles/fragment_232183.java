@RunWith(SpringRunner.class)    
class UserServiceTest{
    @InjectMocks
    UserService userService;

    @Mock
    UserDao userDao;//This is a reference to the interface (UserDao) which is mapped using MyBatis

    ...
}