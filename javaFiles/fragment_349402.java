@ContextConfiguration(classes= {TestSecurityContext.class,UserInfoServiceTest.Config.class})
public class UserInfoServiceTest {

    public static class Config {
        @Bean
        public UserInfoService userInfoService() {
            return new UserInfoServiceImpl();
        }
    }
}