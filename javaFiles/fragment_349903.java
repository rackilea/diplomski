@RunWith(SpringRunner.class)
@SpringBootTest
class UserInsertTest {

    @AutoWired
    private UserService userService;

    @AutoWired
    private UserRepository userRepository;

    @Test
    public void insert() {
        UserEntity user = userService.save(new UserEntity());
        assertNotNull(userRepository.findOne(user.getId());
    }

}