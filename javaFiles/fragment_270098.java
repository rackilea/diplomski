@Configuration
public class SpringTestConfig {
    @Bean
    public UserService userService() {
        return new UserServiceImpl(); // or whatever your implementation is 
    }
    @Bean
    public UserRepository userRepository() {
        return Mockito.mock(UserRepository.class);
    }
}