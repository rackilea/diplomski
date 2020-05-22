// Provide necessary annotations..
public class UserRepositoryIntTest {

    @Autowired UserRepository userRepository;

    @Test
    public void testThemAll() {
        this.userRepository.findOne(2); // 1
        this.userRepository.findOneByNameAndAge("david", 20); // 2
        this.userRepository.findByName("david"); // 3
        this.userRepository.deleteByName("david"); // 4
        this.userRepository.updateByName("dave", "david"); // 5
    }

}